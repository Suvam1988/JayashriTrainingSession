package com.advancedselenium.org.jayashrirasane.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class TestDataLoader {

	public static String propertiesFileReader(String key) {
		FileReader fir = null;
		try {
			fir = new FileReader(
					System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
							+ "resources" + File.separator + "testdata" + File.separator + "testdata.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = prop.getProperty(key);
		return data;
	}
}
