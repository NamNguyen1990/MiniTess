package quanlynhanvien;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainQL {
    public static void main(String[] args) throws IOException {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        Scanner sc = new Scanner(System.in);
        Scanner nhapChu = new Scanner(System.in);
        int luaChon;
        quanLyNhanVien.setNhanVienList(GhiDocFile.readFromFile("KtraMD2.csv",quanLyNhanVien.nhanVienList));
        System.out.println("=====Menu====");
        System.out.println("0 - Hiển thị tất cả Nhân viên");
        System.out.println("1 - Thêm 1 Nhân viên mới");
        System.out.println("2 - Tìm kiếm thông tin nhân viên theo số CMND");
        System.out.println("3 - Tìm kiếm thông tin nhân viên theo tên");
        System.out.println("4 - In ra danh sách nhân viên Fulltime");
        System.out.println("5 - In ra danh sách nhân viên Parttime");
        System.out.println("6 - Sửa thông tin nhân viên theo Tên nhập vào");
        System.out.println("7 - Sửa thông tin nhân viên theo số CMND nhập vào");
        System.out.println("8 - Thay đổi trạng thái nhân viên");
        System.out.println("9 - Lương nhân viên");
        System.out.println("10 - Thoát");

        do {
            System.out.println("Mời bạn chọn chức năng");
            try {
                luaChon = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Chỉ được nhập số");
                sc.nextLine();
                luaChon = -1;
            }

            if (luaChon == 0) {

                quanLyNhanVien.hienThi();

            }
            else if (luaChon == 1) {
                System.out.println("Nhập vào số CMND");
                int soCMND = sc.nextInt();
                System.out.println("Mời nhập họ tên");
                String ten = nhapChu.nextLine();
                System.out.println("Mời nhập vào loại (Fulltime/Parttime)");
                String loai = nhapChu.nextLine();
                System.out.println("Mời nhập vào trạng thái (Đang làm/Thôi việc)");
                String trangThai = nhapChu.nextLine();
                System.out.println("Mời nhập lương của nhân viên");
                int luong = sc.nextInt();

                NhanVien nhanVien = new NhanVien(soCMND,ten,loai,trangThai,luong);
                quanLyNhanVien.them(nhanVien);
                GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);;

            }
            else if (luaChon == 2) {

            }
            else if (luaChon == 3) {

            }
            else if (luaChon == 4) {

            }
            else if (luaChon == 5) {

            }
            else if (luaChon == 6) {

            }
            else if (luaChon == 7) {

            }
            else if (luaChon == 8) {

            }
            else if (luaChon == 9) {

            }


        }while (luaChon != 10);




    }
}
