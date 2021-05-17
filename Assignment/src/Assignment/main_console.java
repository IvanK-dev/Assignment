package Assignment;

public class main_console {

	public static void main(String[] args) {
		
		c_JSONreader o_reader;
		c_Report	 o_report;
		o_reader = new c_JSONreader("C:\\Users\\ivan_\\eclipse-workspace\\Assignment\\src\\Assignment\\data.json",
									"C:\\Users\\ivan_\\eclipse-workspace\\Assignment\\src\\Assignment\\Report_def.json" );
		
		o_reader.readJson_data();
		o_reader.readJson_def();
		o_reader.getEmployees();
		o_reader.getDefinitions();
		
		o_report = new c_Report(o_reader.getP_cDefin(),o_reader.getP_cEmployees(),"test.csv");
		o_report.createCSV();
	}

}
