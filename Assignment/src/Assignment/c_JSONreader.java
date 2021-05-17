package Assignment;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class c_JSONreader {
	
	private String p_sfile_path_data;
	private String p_sfile_path_def;
	private JSONObject p_obj_JSON_def;
	private ArrayList<JSONObject> p_obj_JSON_data;
	private ArrayList<c_Employee> p_cEmployees;
	private c_Definition p_cDefin;
	public c_JSONreader(String file_path_data, String file_path_def) {
		this.p_sfile_path_data = file_path_data;
		this.p_sfile_path_def = file_path_def;
	}
	
	public void getEmployees() {
		p_cEmployees = new ArrayList();
		
		if(!p_obj_JSON_data.isEmpty()) {
			for(int i = 0; i<p_obj_JSON_data.size(); i++) {
				c_Employee employee = new c_Employee((String) 	p_obj_JSON_data.get(i).get("name"), 
													 (Long) 	p_obj_JSON_data.get(i).get("totalSales"), 
													 (Long) 	p_obj_JSON_data.get(i).get("salesPeriod"),
													 (double) 	p_obj_JSON_data.get(i).get("experienceMultiplier"));
						
				p_cEmployees.add(employee);
			}
		}
	}
	
	public void getDefinitions() {
		if(!p_obj_JSON_def.isEmpty()) {
			p_cDefin = new c_Definition((Long)    p_obj_JSON_def.get("topPerformersThreshold"),
										(Boolean) p_obj_JSON_def.get("useExprienceMultiplier"), 
										(Long)    p_obj_JSON_def.get("periodLimit"));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void readJson_data(){
		Object parserJson = null;
		try {
		parserJson = new JSONParser().parse(new FileReader(this.p_sfile_path_data));
		}
		catch(Exception mult_exceptions) {
			System.out.println(mult_exceptions);
		}
		
		
		this.p_obj_JSON_data = (ArrayList<JSONObject>) parserJson;
	}
	
	public void readJson_def(){
		Object parserJson = null;
		try {
		parserJson = new JSONParser().parse(new FileReader(this.p_sfile_path_def));
		}
		catch(Exception mult_exceptions) {
			System.out.println(mult_exceptions);
		}		
		
		this.p_obj_JSON_def = (JSONObject) parserJson;
	}
	
	public c_Definition getP_cDefin() {
		return p_cDefin;
	}
	
	public ArrayList<c_Employee> getP_cEmployees() {
		return p_cEmployees;
	}
}
