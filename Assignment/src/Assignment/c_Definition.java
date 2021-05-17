package Assignment;

public class c_Definition {
	private int p_itPerfthresh, p_iperiodLimit;
	private Boolean p_buseExpMult;
	
	public c_Definition(Long PerfThrsh, boolean useExpMult,Long perLim ) {
		this.p_itPerfthresh = PerfThrsh.intValue();
		this.p_iperiodLimit = perLim.intValue();
		this.p_buseExpMult  = useExpMult;
	}
	
	public int getP_itPerfthresh() {
		return p_itPerfthresh;
	}
	
	public int getP_iperiodLimit() {
		return p_iperiodLimit;
	}
	
	public Boolean getP_buseExpMult() {
		return p_buseExpMult;
	}
}
