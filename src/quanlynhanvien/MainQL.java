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
        Scanner nhapChu2 = new Scanner(System.in);

        int luaChon = -1;

        System.out.println("=====Menu====");
        System.out.println(ANSI_RED + "NOTE: Nhập 10 lần đầu tiên để hiện thị nhân viên có sẵn trước khi thêm mới, nếu không sẽ mất toàn bộ dữ liệu nhân viên!" + ANSI_RESET);
        System.out.println("0 - Hiển thị tất cả Nhân viên");
        System.out.println("1 - Thêm 1 Nhân viên mới");
        System.out.println("2 - Tìm kiếm thông tin nhân viên theo số CMND");
        System.out.println("3 - Tìm kiếm thông tin nhân viên theo tên");  // Tìm kiếm và hiển thị tất cả nhân viên có tên giống nhau!
        System.out.println("4 - In ra danh sách nhân viên Fulltime/Parttime");
        System.out.println("5 - Xóa vĩnh viễn 1 nhân viên trong danh sách theo tên nhập vào");  // Chỉ xóa được người đầu tiên hoặc tên là duy nhất
        System.out.println("6 - Sửa thông tin nhân viên theo Tên nhập vào"); // Chỉ sửa được người đầu tiên tìm thấy!
        System.out.println("7 - Sửa thông tin nhân viên theo số CMND nhập vào");
        System.out.println("8 - Thay đổi trạng thái nhân viên (Từ Đang làm --> Thôi việc)");
        System.out.println("9 - Hiển thị lương nhân viên");
        System.out.println("10 - Hiển thị danh sách nhân viên có sẵn");
        System.out.println("11 - Xóa vĩnh viễn 1 nhân viên trong danh sách theo số CMND");
        System.out.println("12 - Xem lại danh sách Menu!");
        System.out.println("13 - Thoát");

        do {
            boolean check2 = false;
            while (!check2) {
                System.out.println("Mời bạn chọn chức năng");
                try {
                    luaChon = sc.nextInt();
                    if (luaChon<0 || luaChon >12) throw new Exception();
                    check2 = true;
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "Chỉ được nhập số từ 0 --> 12" + ANSI_RESET);
                }
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

                System.out.println("Bạn có muốn thêm người này vào danh sách nhân viên không?" + ANSI_RED + "[Chọn: Y/E(Exit) hoặc nhập bất kỳ để không thêm]" + ANSI_RESET);
                System.out.println(ANSI_RED + "NOTE: Nhập 10 lần đầu tiên để hiện thị nhân viên có sẵn trước khi thêm mới, nếu không sẽ mất toàn bộ dữ liệu nhân viên!" + ANSI_RESET);
                char result, a = 'Y', b = 'E';
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
                System.out.println("Nhập số CMND cần tìm");
                int soCMND = sc.nextInt();
                quanLyNhanVien.timKiemCMND(soCMND);

            }
            else if (luaChon == 3) {
                System.out.println("Nhập tên nhân viên cần tìm");
                String ten = nhapChu.nextLine();
                quanLyNhanVien.timKiemTen(ten);
            }
            else if (luaChon == 4) {
                System.out.println("Bạn muốn in nhân viên làm Fulltime hay Parttime?" + ANSI_RED + "[Chọn: F/P/E(Exit) hoặc nhập bất kỳ để thoát]" + ANSI_RESET);
                char result, a = 'F', b = 'P', c = 'E';
                result = nhapChu2.next().charAt(0);

                if (result == a) {
                    quanLyNhanVien.timKiemFullTime();
                }
                if (result == b) {
                    quanLyNhanVien.timKiemPartTime();
                }
                if (result == c) {
                    System.exit(0);
                }
//                quanLyNhanVien.timKiemFullTime();
            }
//            else if (luaChon == 5) {
//                quanLyNhanVien.timKiemPartTime();
//            }

            else if (luaChon == 5) {
                System.out.println("Nhập tên nhân viên muốn xóa");
                String tenX= nhapChu.nextLine();
                quanLyNhanVien.xoaTen(tenX);
                GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);

            }

            else if (luaChon == 6) {
                System.out.println("Nhập Tên muốn sửa");
                String tenS = nhapChu.nextLine();

                int soCMNDM = -1;
                boolean check3 = false;
                while (!check3) {
                    System.out.println("Nhập Số CMND mới");
                    try {
                        soCMNDM = sc.nextInt();
                        check3 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }
                System.out.println("Nhập Tên mới");
                String tenM = nhapChu.nextLine();
                System.out.println("Nhập Loại mới");
                String loaiM = nhapChu.nextLine();
                System.out.println("Nhập Trạng Thái mới");
                String trangThaiM = nhapChu.nextLine();

                int luongM = -1;
                boolean check4 = false;
                while (!check4) {
                    System.out.println("Nhập Lương mới");
                    try {
                        luongM = sc.nextInt();
                        check4 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                NhanVien nhanVien1 = new NhanVien(soCMNDM,tenM,loaiM,trangThaiM,luongM);
                quanLyNhanVien.suaTen(tenS,nhanVien1);
                GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);

            }
            else if (luaChon == 7) {
                int soCMNDS = -1;
                boolean check5 = false;
                while (!check5) {
                    System.out.println("Nhập số CMND cần tìm sửa");
                    try {
                        soCMNDS = sc.nextInt();
                        check5 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                int soCMNDM = -1;
                boolean check6 = false;
                while (!check6) {
                    System.out.println("Nhập vào số CMND mới");
                    try {
                        soCMNDM = sc.nextInt();
                        check6 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                System.out.println("Nhập vào tên mới");
                String tenM = nhapChu.nextLine();
                System.out.println("Nhập vào loại mới");
                String loaiM = nhapChu.nextLine();
                System.out.println("Nhập vào trạng thái mới");
                String trangThaiM = nhapChu.nextLine();

                int luongM = -1;
                boolean check7 = false;
                while (!check7) {
                    System.out.println("Nhập vào lương mới");
                    try {
                        luongM = sc.nextInt();
                        check7 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                NhanVien nhanVien2 = new NhanVien(soCMNDM,tenM,loaiM,trangThaiM,luongM);
                quanLyNhanVien.suasoCMND(soCMNDS,nhanVien2);
                GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);
                System.out.println("Bạn đã sửa thành công thông tin nhân viên trên");

            }
            else if (luaChon == 8) {

                int soCMNDCN = -1;
                boolean check8 = false;
                while (!check8) {
                    System.out.println("Nhập số CMND của nhân viên cần cập nhật trạng thái!");
                    try {
                        soCMNDCN = sc.nextInt();
                        check8 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                    quanLyNhanVien.capNhatsoCMND(soCMNDCN);
                    GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);

            }
            else if (luaChon == 9) {
                quanLyNhanVien.luong();
            }
            else if (luaChon == 10) {
                System.out.println("Danh sách nhân viên đã có sẵn");
                quanLyNhanVien.setNhanVienList(GhiDocFile.readFromFile("KtraMD2.csv",quanLyNhanVien.nhanVienList));
            }
            else if (luaChon == 11) {

                int soCMNDX = -1;
                boolean check9 = false;
                while (!check9) {
                    System.out.println("Nhập số CMND của nhân viên muốn xóa");
                    try {
                        soCMNDX = sc.nextInt();
                        check9 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                quanLyNhanVien.xoasoCMND(soCMNDX);
                GhiDocFile.writeToFile("KtraMD2.csv",quanLyNhanVien.nhanVienList);

            }

            else if (luaChon == 12) {
                System.out.println("=====Menu====");
                System.out.println(ANSI_RED + "NOTE: Nhập 10 lần đầu tiên để hiện thị nhân viên có sẵn trước khi thêm mới, nếu không sẽ mất toàn bộ dữ liệu nhân viên!" + ANSI_RESET);
                System.out.println("0 - Hiển thị tất cả Nhân viên");
                System.out.println("1 - Thêm 1 Nhân viên mới");
                System.out.println("2 - Tìm kiếm thông tin nhân viên theo số CMND");
                System.out.println("3 - Tìm kiếm thông tin nhân viên theo tên");  // Tìm kiếm và hiển thị tất cả nhân viên có tên giống nhau!
                System.out.println("4 - In ra danh sách nhân viên Fulltime/Parttime");
                System.out.println("5 - Xóa vĩnh viễn 1 nhân viên trong danh sách theo tên nhập vào");  // Chỉ xóa được người đầu tiên hoặc tên là duy nhất
                System.out.println("6 - Sửa thông tin nhân viên theo Tên nhập vào"); // Chỉ sửa được người đầu tiên tìm thấy!
                System.out.println("7 - Sửa thông tin nhân viên theo số CMND nhập vào");
                System.out.println("8 - Thay đổi trạng thái nhân viên (Từ Đang làm --> Thôi việc)");
                System.out.println("9 - Hiển thị lương nhân viên");
                System.out.println("10 - Hiển thị danh sách nhân viên có sẵn");
                System.out.println("11 - Xóa vĩnh viễn 1 nhân viên trong danh sách theo số CMND");
                System.out.println("12 - Xem lại danh sách Menu!");
                System.out.println("13 - Thoát");
            }

        }while (luaChon != 13);

    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

}
