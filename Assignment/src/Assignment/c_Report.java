package Assignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class c_Report {
	private c_Definition p_cDefin;
	private ArrayList<c_Employee> p_cEmployees;
	private String p_sfile_path;
	
	public c_Report(c_Definition defin,ArrayList<c_Employee> employees, String file_path  ) {
		this.p_cDefin 		= defin;
		this.p_cEmployees 	= employees;
		this.p_sfile_path	= file_path;
	}
	
	public double Score(boolean useExpMult,double expMult, int totalSales, int salesPeriod) {
		
		double score;
		if(useExpMult == true) {
			score = totalSales/salesPeriod*expMult;	
		}
		else
			score = totalSales/salesPeriod;
		
		return score;
	}
	
	public void createCSV() {
		try (PrintWriter writer = new PrintWriter(new File(p_sfile_path))){
			
			StringBuilder v_stringBuilder = new StringBuilder();
			
			v_stringBuilder.append("Name");
			v_stringBuilder.append(',');
			v_stringBuilder.append("Score");
			v_stringBuilder.append('\n');
			
			for(int i = 0; i < p_cEmployees.size(); i++ ){
				
				double score = Score(p_cDefin.getP_buseExpMult(), 
									 p_cEmployees.get(i).getP_fexpMulti(), 
									 p_cEmployees.get(i).getP_itotalSales(), 
									 p_cEmployees.get(i).getP_isalesPeriod());
				
				if((p_cEmployees.get(i).getP_isalesPeriod() <= p_cDefin.getP_iperiodLimit()) && (score >= p_cDefin.getP_itPerfthresh())){
					v_stringBuilder.append(p_cEmployees.get(i).getP_sFullName());
					v_stringBuilder.append(',');
					v_stringBuilder.append(String.valueOf(score));
					v_stringBuilder.append('\n');
				}
				
				}
			
			writer.write(v_stringBuilder.toString());
			System.out.println("File created!");
			writer.close();
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}
}
