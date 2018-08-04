import java.awt.List;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class bai3 {
	public java.util.List<HocSinh> list;
	
	public HocSinh timkiem(String ten) {
		for(int i=0; i < list.size(); i++) {
			if(ten.contains(list.get(i).getHoten())) {
				return list.get(i);
			}
		}
		return null;
	}
	public void taomang() {
		try {
			FileOutputStream fos = new FileOutputStream("D:\\tuan.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(int i=1; i <= 100; i++) {
				HocSinh hs = new HocSinh(baitap.taoHoTen(), baitap.createDate("22/10/2015", "22/11/2015") , baitap.diemtrungbinh());
				hs.kiemTraKetQua();
				hs.loaiHocTap();
				oos.writeObject(hs);
			}
			fos.close();
			oos.close();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void docmang() {
		list = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("D:\\tuan.bin");
			ObjectInputStream  ois = new ObjectInputStream(fis);
			for(int i=1; i <= 100; i++) {
				list.add((HocSinh) ois.readObject());
			}
			fis.close();
			ois.close();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void xuatdanhsach() {
		for (HocSinh hocSinh : list) {
			System.out.println(hocSinh.getHoten() + " " + hocSinh.getNgaysinh() + " " + hocSinh.getDiemtrungbinh() +" " + hocSinh.kiemTraKetQua() 
			+ " " + hocSinh.loaiHocTap());
			
		}
	}
	
	public double tinhTrungBinhCong() {
		double tbc = 0;
		for (HocSinh hocSinh : list) {
			tbc += hocSinh.getDiemtrungbinh();
		}
		return tbc / list.size();
	}
}
