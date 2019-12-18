package com.wipro.holmes.uhg.model;

import java.util.ArrayList;
import java.util.List;

public class AggregateLogModel {
	private List<LogModel> logs;

	public AggregateLogModel() {
		logs=new ArrayList<LogModel>();
	}

	public AggregateLogModel(List<LogModel> logs) {
		super();
		this.logs = logs;
	}

	public List<LogModel> getLogs() {
		return logs;
	}

	public void setLogs(List<LogModel> logs) {
		this.logs = logs;
	}

	@Override
	public String toString() {
		return "AggregateLogModel [logs=" + logs + "]";
	}

}
