package com.company.web.factory;

import com.company.web.enums.Vendor;

public class DatabaseFactory {
	public static Database createDatabase(String vendor) {
		Database db = null;
		switch (Vendor.valueOf(vendor)) {
		case ORACLE: db = new Oracle();
			break;
		}
		return db;
	}
}
