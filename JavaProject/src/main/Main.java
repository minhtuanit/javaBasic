package main;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;

public class Main extends JFrame{

	private JPanel contentPane;
	private JTextField txtGia;
	private JTextField txtSoLuong;
	private JTextField txtThanhTien;
	private JTextField txtBangChu;
	private Choice choice;
	private List<MatHang> listMatHang = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chon Hang");
		lblNewLabel.setBounds(10, 11, 62, 14);
		contentPane.add(lblNewLabel);
		
		choice = new Choice();
		choice.setBounds(78, 11, 85, 20);
		contentPane.add(choice);
		listMatHang.add(new MatHang("Kẹo Mút", 30));
		listMatHang.add(new MatHang("Bánh Ép", 50));
		listMatHang.add(new MatHang("Cafe", 20));
		for (MatHang matHang : listMatHang) {
			choice.add(matHang.getTenMatHang());
		}
		
		
		JLabel lblGia = new JLabel("Gia");
		lblGia.setBounds(10, 56, 46, 14);
		contentPane.add(lblGia);
		
		txtGia = new JTextField();
		txtGia.setBounds(77, 53, 86, 20);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		txtGia.setText(listMatHang.get(0).getGiaMatHang() + "");
		
		JLabel lblNhapSoLuong = new JLabel("Nhap so luong");
		lblNhapSoLuong.setBounds(10, 87, 68, 14);
		contentPane.add(lblNhapSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(78, 84, 85, 20);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblThanhTien = new JLabel("Thanh Tien");
		lblThanhTien.setBounds(10, 128, 68, 14);
		contentPane.add(lblThanhTien);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setBounds(77, 125, 86, 20);
		contentPane.add(txtThanhTien);
		txtThanhTien.setColumns(10);
		
		JLabel lblBangChu = new JLabel("Bang Chu");
		lblBangChu.setBounds(10, 159, 46, 14);
		contentPane.add(lblBangChu);
		
		txtBangChu = new JTextField();
		txtBangChu.setBounds(77, 156, 336, 20);
		contentPane.add(txtBangChu);
		txtBangChu.setColumns(10);
		
		JButton btnTinhTien = new JButton("Tinh Tien");
		btnTinhTien.setBounds(78, 205, 89, 23);
		contentPane.add(btnTinhTien);
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				for(int i=0; i <= listMatHang.size(); i++) {
					if(listMatHang.get(i).getTenMatHang().equals(e.getItem())) {
						txtGia.setText(listMatHang.get(i).getGiaMatHang() + "");
						break;
					}
				}
			}
		});
		btnTinhTien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long tien = Long.parseLong(txtGia.getText());
				long soluong = Long.parseLong(txtSoLuong.getText());
				txtThanhTien.setText(tien*soluong + "");
				double thanhtienbangchu = tien * soluong;
				txtBangChu.setText(numberToString((thanhtienbangchu)));
			}
		});
	}
	public static String formatNumberForRead(double number) {
        NumberFormat nf = NumberFormat.getInstance();
        String temp = nf.format(number);
        String strReturn = "";
        int slen = temp.length();
        for (int i = 0; i < slen; i++) {
            if (String.valueOf(temp.charAt(i)).equals("."))
                break;
            else if (Character.isDigit(temp.charAt(i))) {
                strReturn += String.valueOf(temp.charAt(i));
            }
        }
        return strReturn;

    }
    public static String numberToString(double number) {
        String sNumber = formatNumberForRead(number);
        // Tao mot bien tra ve
        String sReturn = "";
        // Tim chieu dai cua chuoi
        int iLen = sNumber.length();
        // Lat nguoc chuoi nay lai
        String sNumber1 = "";
        for (int i = iLen - 1; i >= 0; i--) {
            sNumber1 += sNumber.charAt(i);
        }
        // Tao mot vong lap de doc so
        // Tao mot bien nho vi tri cua sNumber
        int iRe = 0;
        do {
            // Tao mot bien cat tam
            String sCut = "";
            if (iLen > 3) {
                sCut = sNumber1.substring((iRe * 3), (iRe * 3) + 3);
                sReturn = Read(sCut, iRe) + sReturn;
                iRe++;
                iLen -= 3;
            } else {
                sCut = sNumber1.substring((iRe * 3), (iRe * 3) + iLen);
                sReturn = Read(sCut, iRe) + sReturn;
                break;
            }
        } while (true);
        if(sReturn.length() > 1){
            sReturn = sReturn.substring(0,1).toUpperCase() + sReturn.substring(1);
        }
        sReturn = sReturn + "đồng";
        return sReturn;
    }

    // Khoi tao ham Read
    public static String Read(String sNumber, int iPo) {
        // Tao mot bien tra ve
        String sReturn = "";
        // Tao mot bien so
        String sPo[] = { "", "ngàn" + " ",
                "triệu" + " ", "tỷ" + " " };
        String sSo[] = { "không" + " ", "một" + " ",
                "hai" + " ", "ba" + " ",
                "bốn" + " ", "năm" + " ",
                "sáu" + " ", "bảy" + " ",
                "tám" + " ", "chín" + " " };
        String sDonvi[] = { "", "mươi" + " ",
                "trăm" + " " };
        // Tim chieu dai cua chuoi
        int iLen = sNumber.length();
        // Tao mot bien nho vi tri doc
        int iRe = 0;
        // Tao mot vong lap de doc so
        for (int i = 0; i < iLen; i++) {
            String sTemp = "" + sNumber.charAt(i);
            int iTemp = Integer.parseInt(sTemp);
            // Tao mot bien ket qua
            String sRead = "";
            // Kiem tra xem so nhan vao co = 0 hay ko
            if (iTemp == 0) {
                switch (iRe) {
                case 0:
                    break;// Khong lam gi ca
                case 1: {
                    if (Integer.parseInt("" + sNumber.charAt(0)) != 0) {
                        sRead = "lẻ" + " ";
                    }
                    break;
                }
                case 2: {
                    if (Integer.parseInt("" + sNumber.charAt(0)) != 0
                            && Integer.parseInt("" + sNumber.charAt(1)) != 0) {
                        sRead = "không trăm" + " ";
                    }
                    break;
                }
                }
            } else if (iTemp == 1) {
                switch (iRe) {
                case 1:
                    sRead = "mười" + " ";
                    break;
                default:
                    sRead = "một" + " " + sDonvi[iRe];
                    break;
                }
            } else if (iTemp == 5) {
                switch (iRe) {
                case 0: {
                    if(sNumber.length() <= 1){
                        sRead = "năm" + " ";
                    }
                    else if (Integer.parseInt("" + sNumber.charAt(1)) != 0) {
                        sRead = "lăm" + " ";
                    } else
                        sRead = "năm" + " ";
                    break;
                }
                default:
                    sRead = sSo[iTemp] + sDonvi[iRe];
                }
            } else {
                sRead = sSo[iTemp] + sDonvi[iRe];
            }

            sReturn = sRead + sReturn;
            iRe++;
        }
        if (sReturn.length() > 0) {
            sReturn += sPo[iPo];
        }

        return sReturn;
    }

    public static String getRomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
          int matches = Int/entry.getValue();
          res += repeat(entry.getKey(), matches);
          Int = Int % entry.getValue();
        }
        return res;
  }
  public static String repeat(String s, int n) {
    if(s == null) {
        return null;
    }
    final StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
        sb.append(s);
    }
    return sb.toString();
  }
}
