package com.devdays103.impl;

import com.devdays103.dto.GeocodingReplyDTO;
import org.ops4j.pax.exam.ConfigurationManager;
import org.ops4j.pax.exam.Option;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.replaceConfigurationFile;

public class TestUtil {
	public static final GeocodingReplyDTO GEO_ATHENS =
			new GeocodingReplyDTO("CITY", "37.9833333", "23.7333333", "Athens");
	public static final GeocodingReplyDTO GEO_BELGIUM =
			new GeocodingReplyDTO("CITY", "50.833333", "4.333333", "Brussels");
	public static final GeocodingReplyDTO GEO_UK =
			new GeocodingReplyDTO("CITY", "51.5", "-0.116667", "London");

	public static final String LOC_ATHENS = "Athens, Greece";
	public static final String LOC_BRUSSELS = "Brussels, Belgium";
	public static final String LOC_UK = "London, UK";

	public static String karafVersion() {
		ConfigurationManager cm = new ConfigurationManager();
		return cm.getProperty("pax.exam.karaf.version");
	}

	public static String projectVersion() {
		ConfigurationManager cm = new ConfigurationManager();
		return cm.getProperty("project.version");
	}

	public static Option copyMockConf(String path) {
		return replaceConfigurationFile(path, new File("src/test/conf/mock/" + path));
	}

	public static Option copyITConf(String path) {
		return replaceConfigurationFile(path, new File("src/test/conf/it/" + path));
	}

	public static boolean isMySQLAcceptingConnection(String url, String user, String pass) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pass);
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ignore) {
				}
		}
	}

}
