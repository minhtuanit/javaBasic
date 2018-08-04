import java.io.Serializable;

public class HocSinh implements Serializable {
	private String hoten;
	private boolean daurot;
	private String loaihoctap;
	public HocSinh(String hoten, String ngaysinh, double diemtrungbinh) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.diemtrungbinh = diemtrungbinh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public double getDiemtrungbinh() {
		return diemtrungbinh;
	}
	public void setDiemtrungbinh(double diemtrungbinh) {
		this.diemtrungbinh = diemtrungbinh;
	}
	private String ngaysinh;
	private double diemtrungbinh;
	
	public String kiemTraKetQua() {
		if(diemtrungbinh >= 5) {
			daurot = true;
			return "Dau";
		}
		else {
			daurot = false;
			return "Rot";
		}
		
	}
	public String loaiHocTap() {
		if(diemtrungbinh >= 8) {
			loaihoctap = "Gioi";
			return "Gioi";
		}
		else if( diemtrungbinh >= 6.5 && diemtrungbinh <= 7.9) {
			loaihoctap = "Kha";
			return "Kha";
		}
		else if(diemtrungbinh >= 5 && diemtrungbinh <= 6.4) {
			loaihoctap = "Trung Binh";
			return "Trung Binh";
		}
		else {
			loaihoctap = "Kem";
			return "Kem";
		}
	}
}
