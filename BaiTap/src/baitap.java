import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class baitap {
	public static String createDate(String ngay1,String ngay2) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date1 = format.parse(ngay1);
			java.util.Date date2 = format.parse(ngay2);
			Random r = new Random();
			while(true) {
				long number = r.nextInt(1000000000) + date1.getTime();
				if(number >= date1.getTime() && number <= date2.getTime()) {
					java.util.Date res = new java.util.Date(number);
					return format.format(res);
				}
			}
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	
	public static double diemtrungbinh() {
		return new Random().nextInt(10);
	}
	
	public static  String taoHoTen() {
		String [] arrHo = new String[]{"Pham","Minh","Van"};
		String [] arrTen = new String[] {"Ku","Te","Baby"};
		String [] arrLot = new String[] {"Ngu","Van","Kute"};
		Random random = new Random();
		int ho = random.nextInt(arrHo.length);
		int ten = random.nextInt(arrTen.length);
		int lot = random.nextInt(arrLot.length);
		
		return arrHo[ho] + " " + arrTen[ten] + " " + arrLot[lot];
	}
	public static void main(String[] args) {
	
		
		bai3 b = new bai3();
		b.taomang();
		b.docmang();
		b.xuatdanhsach();
		

	}

}
