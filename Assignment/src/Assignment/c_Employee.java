package Assignment;

public class c_Employee {
 private String p_sFullName;
 private int p_itotalSales, p_isalesPeriod;
 private double p_fexpMulti;
 
 public c_Employee(String name, Long totalSales, Long salesPeriod, double expMulti) {
	 this.p_sFullName 		= name;
	 this.p_itotalSales 	= totalSales.intValue();
	 this.p_isalesPeriod 	= salesPeriod.intValue();
	 this.p_fexpMulti		= expMulti;
 }
 
 public String getP_sFullName() {
	return p_sFullName;
}
 
 public int getP_itotalSales() {
	return p_itotalSales;
}
 
 public int getP_isalesPeriod() {
	return p_isalesPeriod;
}
 
 public double getP_fexpMulti() {
	return p_fexpMulti;
}
 
}
