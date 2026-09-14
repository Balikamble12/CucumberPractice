package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {
	Properties pro;
	
	public readconfig() {
	       
		try{
		FileInputStream fis= new FileInputStream("./config/config.properties");
		pro= new Properties();
		pro.load(fis);
		 fis.close();
		}catch(Exception e)
		{
			e.getMessage();
		}
	}
	



public String Geturl() {
	return pro.getProperty("url");
}
public String getusername() {
	return pro.getProperty("username");
}
public String getPassword() {
	return pro.getProperty("password");
}

}