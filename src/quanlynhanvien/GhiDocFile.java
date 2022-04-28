package quanlynhanvien;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class GhiDocFile {
    public static void writeToFile (List<NhanVien> nhanVienList) throws IOException {
        File file = new File("KtraMD2.csv");
        PrintWriter pw = new PrintWriter(file);
        String str = "số CMND, tên, loại, trạng Thái, lương" +"\n";
        for (NhanVien i: nhanVienList) {
            str += i.getSoCMND() + "," + i.getTen() + "," + i.getLoai() + "," + i.getTrangThai() + "," + i.getLuong() +"\n";
        }
        pw.write(str);
        pw.close();
    }


    public static void readFromFile (List<NhanVien> nhanVienList) throws IOException {
        File file = new File("KtraMD2.csv");
        Scanner sc = new Scanner(file);
//        FileReader fileReader = new FileReader(file);
        while (sc.hasNext()) {
            String a = sc.nextLine();
//            String[] value = a.split(",");
//            nhanVienList.add(new NhanVien(Integer.parseInt(value[0]), value[1], value[2], value[3], Integer.parseInt(value[4])));
            System.out.println(a);
        }
        sc.close();
    }

}
