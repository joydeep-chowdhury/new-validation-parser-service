package com.wipro.holmes.uhg.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.holmes.uhg.model.AggregateGSFModel;
import com.wipro.holmes.uhg.model.AggregateLogModel;
import com.wipro.holmes.uhg.model.ErrorMessage;
import com.wipro.holmes.uhg.model.ErrorResponse;
import com.wipro.holmes.uhg.model.GSFModel;
import com.wipro.holmes.uhg.model.GSFOptionalModel;
import com.wipro.holmes.uhg.model.GenericResponseModel;
import com.wipro.holmes.uhg.model.LogModel;

@Service
public class GSFParserService {
	@Autowired
	private KieSession session;
	private static final Logger LOGGER = LoggerFactory.getLogger(GSFParserService.class);
	@Value("${exception.path}")
	private String exceptionPath;

	public GenericResponseModel parse() {
		String filename = "gsf_format1.3";
		System.out.println(exceptionPath);
		BufferedReader br = null;
		// List<AggregateGSFModel> aggregateModels=new ArrayList<AggregateGSFModel>();
		List responseObject = new ArrayList();
		String line = "";
		try {
			br = new BufferedReader(new FileReader(filename));
			System.out.println("---------Contents of the file---------\n-------------------------------------\n");
			int exceptionedRowCount = 0;
			int recordCount = 0;
			AggregateLogModel logModelFinal = new AggregateLogModel();
			while ((line = br.readLine()) != null) {
				recordCount++;
				AggregateGSFModel aggModel = new AggregateGSFModel();
				boolean recordExceptionChecker = false;
				GSFModel gsfModel = new GSFModel();
				gsfModel.setVersionIndicator(line.substring(0, 5).trim());
				gsfModel.setSubmissionGroupId(line.substring(5, 13).trim());
				gsfModel.setRelationshipCode(line.substring(25, 27).trim());
				gsfModel.setEmployeeId(line.substring(27, 38).trim());
				gsfModel.setMemberSocialSecurityNumber(line.substring(42, 53).trim());
				gsfModel.setEmploymentDate(line.substring(88, 96).trim());
				gsfModel.setMemberLastName(line.substring(108, 128).trim());
				gsfModel.setMemberFirstName(line.substring(128, 140).trim());
				gsfModel.setMemberMiddleInitial(line.substring(148, 149).trim());
				gsfModel.setMemberBirthDate(line.substring(168, 176).trim());
				gsfModel.setMemberGender(line.substring(188, 189).trim());
				gsfModel.setMemberMaritalStatus(line.substring(189, 190).trim());
				gsfModel.setPermanentStreetAddress1(line.substring(214, 246).trim());
				gsfModel.setPermanentCity(line.substring(278, 298).trim());
				gsfModel.setPermanentState(line.substring(298, 300).trim());
				gsfModel.setPermanentZipCode(line.substring(300, 315).trim());
				gsfModel.setPermanentCountryCode(line.substring(315, 317).trim());
				gsfModel.setHomePhoneNumber(line.substring(422, 432).trim());
				gsfModel.setCoverage1(line.substring(1199, 1202).trim());
				gsfModel.setCoverage1CoverageStartDate(line.substring(1202, 1210).trim());

				String submissionGroupId = gsfModel.getSubmissionGroupId();
				String relationShipCode = gsfModel.getRelationshipCode();

				aggModel.setGsfModel(gsfModel);
				if (!line.substring(57, 72).isBlank() || !line.substring(72, 83).isBlank()) {
					GSFOptionalModel gsfoptionalModal = new GSFOptionalModel();
					gsfoptionalModal.setFormerEEID(line.substring(57, 72).trim());
					gsfoptionalModal.setPersonnelId(line.substring(72, 83).trim());
					aggModel.setGsfOptionalModel(gsfoptionalModal);
				}
				// aggregateModels.add(aggModel);
				ErrorResponse errorResponse = new ErrorResponse();
				ErrorMessage errorMessagerule = new ErrorMessage();

//                session.insert(gsfModel);
//                session.fireAllRules();
//				System.out.println(gsfModel);
				List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
				FactHandle handle = session.insert(gsfModel);
				errorList.forEach(session::insert);
				session.fireAllRules();
				Collection<?> collect = session.getObjects(o -> o.getClass() == ErrorMessage.class);
				List<ErrorMessage> errMsgs= (List<ErrorMessage>) collect.stream().collect(Collectors.toList());
                 errMsgs.forEach(System.out::println);
				 for( Object object: session.getObjects() ){
				        session.retract( session.getFactHandle( object ) );
				     }
                if(errMsgs.size()>0)
                {
                	recordExceptionChecker = true;
                	errorResponse.setErrorMessages(errMsgs);
                }
				

				if (recordExceptionChecker == true) {
					exceptionedRowCount++;
                    responseObject.add(errorResponse);
					LogModel logModel = new LogModel();
					logModel.setRecord(recordCount);
					logModel.setErrorResponse(errorResponse);
					List<LogModel> logModels = logModelFinal.getLogs();
					logModels.add(logModel);
					logModelFinal.setLogs(logModels);
				} else {
					responseObject.add(aggModel);
				}

			}
			br.close();
			if (exceptionedRowCount > 5) {
				String finalLogString = "";

				List<LogModel> logs = logModelFinal.getLogs();
				for (LogModel log : logs) {
					ObjectMapper Obj = new ObjectMapper();
					String jsonStr = Obj.writeValueAsString(log);
					finalLogString = finalLogString + jsonStr + System.lineSeparator();
				}
				String fileName = new SimpleDateFormat("yyyyMMddHHmmssss'.txt'").format(new Date());
				FileWriter fw = new FileWriter(exceptionPath + fileName);
				fw.write(finalLogString);
				fw.close();
				// sendEmail(finalLogString);
				LOGGER.error(exceptionedRowCount + " gsf records encountered validation error---------"
						+ System.lineSeparator() + logModelFinal);
			}
			GenericResponseModel responseFinal = new GenericResponseModel();
			responseFinal.setResponseObject(responseObject);
			return responseFinal;
//                  System.out.println(aggregateModels);
//                  ResponseModel response=new ResponseModel();
//                  response.setResponseObject(aggregateModels);
//                  return response;
		} catch (FileNotFoundException e) {
			System.err.println("Oops! Please check for the presence of file in the path specified.");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.err.println("Oops! Unable to read the file.");
			e.printStackTrace();
			return null;
		}
	}

//	public boolean sendEmail(String messageBody) {
//		String userName = "joydeep.chowdhury@wipro.com";
//		String password = "Rahul@52";
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp-mail.outlook.com");
//		props.put("mail.smtp.port", "587");
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			@Override
//			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//				return new javax.mail.PasswordAuthentication(userName, password);
//			}
//		});
//		session.setDebug(true);
//		 try {
//
//		        Message message = new MimeMessage(session);
//		        message.setFrom(new InternetAddress(userName));
//		        message.setRecipients(Message.RecipientType.TO,
//		            InternetAddress.parse("sunny.kumar16@wipro.com"));   // like inzi769@gmail.com
//		        message.setSubject("Error notification");
//		        message.setText(messageBody);
//
//		        Transport.send(message);
//
//		        System.out.println("Done");
//		        return true;
//
//		    } catch (MessagingException e) {
//		        throw new RuntimeException(e);
//		       
//		    }
//	}

//	public boolean sendEmail(String messageBody) {
//		String userName = "joydeepc101@gmail.com";
//		String password = "01101993@tsk";
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			@Override
//			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//				return new javax.mail.PasswordAuthentication(userName, password);
//			}
//		});
//		session.setDebug(true);
//		 try {
//
//		        Message message = new MimeMessage(session);
//		        message.setFrom(new InternetAddress(userName));
//		        message.setRecipients(Message.RecipientType.TO,
//		            InternetAddress.parse("sunnykumar3306@gmail.com"));   // like inzi769@gmail.com
//		        message.setSubject("Error notification");
//		        message.setText(messageBody);
//
//		        Transport.send(message);
//
//		        System.out.println("Done");
//		        return true;
//
//		    } catch (MessagingException e) {
//		        throw new RuntimeException(e);
//		       
//		    }
//	}

}
