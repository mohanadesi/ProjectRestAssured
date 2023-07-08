package com.sl.tests;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;
public class LibraryReqResData {

	String strName = "Naveen";
	String strRole = "TL";
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrRole() {
		return strRole;
	}
	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}
	//JSON object creation method
	public JSONObject DataJsonCreateUser() {
		JSONObject jsonUserData = new JSONObject();
		jsonUserData.put("name", strName);
		jsonUserData.put("job", strRole);
		return jsonUserData;
	}
	//Read Json file
	public String ReadFileToString(){
		String strpostData = "";
		String strPath = "C:\\Users\\mohan\\Documents\\json datafiles\\Data1.json";
		Path path = Paths.get(strPath);
		try{
			strpostData = new String(Files.readAllBytes(path));
			}
			catch(IOException e){
			e.printStackTrace();
			}
		return strpostData;
	
	}
	
}
