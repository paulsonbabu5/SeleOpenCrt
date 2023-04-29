package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="dp1")
	public String[][]testData() throws IOException
	{
		String path="C:\\Users\\pauls\\eclipse-workspace\\opencart_april27\\src\\test\\java\\testData\\data.xlsx";
		ExcelUtility xlutility=new ExcelUtility(path);
		int totalrows=xlutility.getRowCount("Sheet1");
		int totalcolms=xlutility.getCellCount("Sheet1",1);
		String logindata[][]= new String[totalrows][totalcolms];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcolms;j++)
			{
				logindata[i-1][j]=xlutility.getCellData("sheet1", i, j);
			}
			
		}
		return logindata;
		
	}
}
