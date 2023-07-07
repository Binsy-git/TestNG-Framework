package testdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import base.BaseHooks;

import utils.ExcelUtility;

public class TestDataProvider extends BaseHooks {
	
	public String excelFileName;
	
	@DataProvider
	public String[][] fetchdata() throws IOException {
		
		return ExcelUtility.readexcel();
	}

}