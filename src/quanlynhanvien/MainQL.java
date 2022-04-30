package quanlynhanvien;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainQL {
    public static void main(String[] args) throws IOException {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        Scanner sc = new Scanner(System.in);
        Scanner nhapChu = new Scanner(System.in);
        Scanner nhapChu1 = new Scanner(System.in);

        int luaChon = -1;

        System.out.println("=====Menu====");
        System.out.println(ANSI_RED + "NOTE: Nhập 10 lần đầu tiên để hiện thị nhân viên có sẵn trước khi thêm mới, nếu không sẽ mất toàn bộ dữ liệu nhân viên!" + ANSI_RESET);
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
        System.out.println("10 - Hiển thị danh sách nhân viên có sẵn");
        System.out.println("11 - Xóa vĩnh viễn 1 nhân viên trong danh sách");
        System.out.println("12 - Thoát");

        do {
            System.out.println("Mời bạn chọn chức năng");
            try {
                luaChon = sc.nextInt();
                if (luaChon<0 || luaChon >12) throw new Exception();
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Chỉ được nhập số từ 0 --> 12" + ANSI_RESET);
            }

            if (luaChon == 0) {

                quanLyNhanVien.hienThi();

            }
            else if (luaChon == 1) {
                int soCMND = -1;
                boolean check = false;
                while (!check) {
                    System.out.println("Nhập vào số CMND");
                    try {
                        soCMND = sc.nextInt();
                        check = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }
                System.out.println("Mời nhập họ tên");
                String ten = nhapChu.nextLine();
                System.out.println("Mời nhập vào loại (Fulltime/Parttime)");
                String loai = nhapChu.nextLine();
                System.out.println("Mời nhập vào trạng thái (Đang làm/Thôi việc)");
                String trangThai = nhapChu.nextLine();
                int luong = -1;
                boolean check1 = false;
                while (!check1) {
                    System.out.println("Mời nhập lương của nhân viên");
                    try {
                        luong = sc.nextInt();
                        check1 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                NhanVien nhanVien = new NhanVien(soCMND,ten,loai,trangThai,luong);


                System.out.println("Bạn có muốn thêm người này vào danh sách nhân viên không?" + ANSI_RED + "(Chọn: Y/N)" + ANSI_RESET);
                System.out.println(ANSI_RED + "NOTE: Nhập 10 lần đầu tiên để hiện thị nhân viên có sẵn trước khi thêm mới, nếu không sẽ mất toàn bộ dữ liệu nhân viên!" + ANSI_RESET);
                char result, a = 'Y', b = 'N';
                result = nhapChu1.next().charAt(0);
                if (result == a) {
                    quanLyNhanVien.them(nhanVien);
                    GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);
                }
                if (result == b) {
                    System.exit(0);
                }


//                quanLyNhanVien.them(nhanVien);
//                GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);

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
            else if (luaChon == 10) {
                System.out.println("Danh sách nhân viên đã có sẵn");
                quanLyNhanVien.setNhanVienList(GhiDocFile.readFromFile("KtraMD2.csv",quanLyNhanVien.nhanVienList));
            }
            else if (luaChon == 11) {

            }

        }while (luaChon != 12);

    }



    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

}
