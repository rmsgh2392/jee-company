package com.company.web.enums;

public enum DBDriver {
	ORACLE_DRIVER,
	MARIA_DIRVER;
	
	@Override
	public String toString() {
		String driver = "";
		switch (this) {
		case ORACLE_DRIVER : driver = "oracle.jdbc.OracleDriver"; break;
		}
		return driver;
	}
}
