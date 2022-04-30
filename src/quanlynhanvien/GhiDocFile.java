package quanlynhanvien;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class GhiDocFile {
    public static void writeToFile (String path,List<NhanVien> nhanVienList) throws IOException {
        File file = new File(path);
        PrintWriter pw = new PrintWriter(file);
        String str = "Số CMND, Tên, Loại, Trạng Thái, Lương" +"\n";
        for (NhanVien i: nhanVienList) {
            str += i.getSoCMND() + "," + i.getTen() + "," + i.getLoai() + "," + i.getTrangThai() + "," + i.getLuong() +"\n";
        }
        pw.write(str);
        pw.close();
    }


    public static List<NhanVien> readFromFile (String path,List<NhanVien> nhanVienList) throws IOException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String[] value = a.split(",");
            nhanVienList.add(new NhanVien(Integer.parseInt(value[0]), value[1], value[2], value[3], Integer.parseInt(value[4])));
            System.out.println(a);
        }
        sc.close();
        return nhanVienList;
    }

}
