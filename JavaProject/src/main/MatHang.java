package main;

public class MatHang {
	private String tenMatHang;
	private long giaMatHang;
	
	public MatHang(String tenMatHang,long giaMatHang) {
		this.tenMatHang = tenMatHang;
		this.giaMatHang = giaMatHang;
	}
	
	public String getTenMatHang() {
		return tenMatHang;
	}
	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}
	public long getGiaMatHang() {
		return giaMatHang;
	}
	public void setGiaMatHang(long giaMatHang) {
		this.giaMatHang = giaMatHang;
	}
}
