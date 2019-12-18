package com.wipro.holmes.uhg.model;

public class GSFModel {
	public String versionIndicator;
	public String submissionGroupId;
	public String relationshipCode;
	public String employeeId;
	public String memberSocialSecurityNumber;
	private String employmentDate;
	private String memberLastName;
	private String memberFirstName;
	private String memberMiddleInitial;
	private String memberBirthDate;
	private String memberGender;
	private String memberMaritalStatus;
	private String permanentStreetAddress1;
	private String permanentCity;
	private String permanentState;
	private String permanentZipCode;
	private String permanentCountryCode;
	private String homePhoneNumber;
	private String coverage1;
	private String coverage1CoverageStartDate;
	

	public GSFModel() {
	}

	

	public GSFModel(String versionIndicator, String submissionGroupId, String relationshipCode, String employeeId,
			String memberSocialSecurityNumber, String employmentDate, String memberLastName, String memberFirstName,
			String memberMiddleInitial, String memberBirthDate, String memberGender, String memberMaritalStatus,
			String permanentStreetAddress1, String permanentCity, String permanentState, String permanentZipCode,
			String permanentCountryCode, String homePhoneNumber, String coverage1, String coverage1CoverageStartDate) {
		super();
		this.versionIndicator = versionIndicator;
		this.submissionGroupId = submissionGroupId;
		this.relationshipCode = relationshipCode;
		this.employeeId = employeeId;
		this.memberSocialSecurityNumber = memberSocialSecurityNumber;
		this.employmentDate = employmentDate;
		this.memberLastName = memberLastName;
		this.memberFirstName = memberFirstName;
		this.memberMiddleInitial = memberMiddleInitial;
		this.memberBirthDate = memberBirthDate;
		this.memberGender = memberGender;
		this.memberMaritalStatus = memberMaritalStatus;
		this.permanentStreetAddress1 = permanentStreetAddress1;
		this.permanentCity = permanentCity;
		this.permanentState = permanentState;
		this.permanentZipCode = permanentZipCode;
		this.permanentCountryCode = permanentCountryCode;
		this.homePhoneNumber = homePhoneNumber;
		this.coverage1 = coverage1;
		this.coverage1CoverageStartDate = coverage1CoverageStartDate;
	}



	public String getVersionIndicator() {
		return versionIndicator;
	}

	public void setVersionIndicator(String versionIndicator) {
		this.versionIndicator = versionIndicator;
	}

	public String getSubmissionGroupId() {
		return submissionGroupId;
	}

	public void setSubmissionGroupId(String submissionGroupId) {
		this.submissionGroupId = submissionGroupId;
	}

	public String getRelationshipCode() {
		return relationshipCode;
	}

	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getMemberSocialSecurityNumber() {
		return memberSocialSecurityNumber;
	}

	public void setMemberSocialSecurityNumber(String memberSocialSecurityNumber) {
		this.memberSocialSecurityNumber = memberSocialSecurityNumber;
	}

	public String getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberMiddleInitial() {
		return memberMiddleInitial;
	}

	public void setMemberMiddleInitial(String memberMiddleInitial) {
		this.memberMiddleInitial = memberMiddleInitial;
	}

	public String getMemberBirthDate() {
		return memberBirthDate;
	}

	public void setMemberBirthDate(String memberBirthDate) {
		this.memberBirthDate = memberBirthDate;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberMaritalStatus() {
		return memberMaritalStatus;
	}

	public void setMemberMaritalStatus(String memberMaritalStatus) {
		this.memberMaritalStatus = memberMaritalStatus;
	}

	public String getPermanentStreetAddress1() {
		return permanentStreetAddress1;
	}



	public void setPermanentStreetAddress1(String permanentStreetAddress1) {
		this.permanentStreetAddress1 = permanentStreetAddress1;
	}



	public String getPermanentCity() {
		return permanentCity;
	}



	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}



	public String getPermanentState() {
		return permanentState;
	}



	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}



	public String getPermanentZipCode() {
		return permanentZipCode;
	}



	public void setPermanentZipCode(String permanentZipCode) {
		this.permanentZipCode = permanentZipCode;
	}



	public String getPermanentCountryCode() {
		return permanentCountryCode;
	}



	public void setPermanentCountryCode(String permanentCountryCode) {
		this.permanentCountryCode = permanentCountryCode;
	}



	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}



	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}



	public String getCoverage1() {
		return coverage1;
	}



	public void setCoverage1(String coverage1) {
		this.coverage1 = coverage1;
	}



	public String getCoverage1CoverageStartDate() {
		return coverage1CoverageStartDate;
	}



	public void setCoverage1CoverageStartDate(String coverage1CoverageStartDate) {
		this.coverage1CoverageStartDate = coverage1CoverageStartDate;
	}



	@Override
	public String toString() {
		return "GSFModel [versionIndicator=" + versionIndicator + ", submissionGroupId=" + submissionGroupId
				+ ", relationshipCode=" + relationshipCode + ", employeeId=" + employeeId
				+ ", memberSocialSecurityNumber=" + memberSocialSecurityNumber + ", employmentDate=" + employmentDate
				+ ", memberLastName=" + memberLastName + ", memberFirstName=" + memberFirstName
				+ ", memberMiddleInitial=" + memberMiddleInitial + ", memberBirthDate=" + memberBirthDate
				+ ", memberGender=" + memberGender + ", memberMaritalStatus=" + memberMaritalStatus
				+ ", permanentStreetAddress1=" + permanentStreetAddress1 + ", permanentCity=" + permanentCity
				+ ", permanentState=" + permanentState + ", permanentZipCode=" + permanentZipCode
				+ ", permanentCountryCode=" + permanentCountryCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", coverage1=" + coverage1 + ", coverage1CoverageStartDate=" + coverage1CoverageStartDate + "]";
	}




	}


