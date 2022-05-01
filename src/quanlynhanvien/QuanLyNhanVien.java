package quanlynhanvien;

import java.util.ArrayList;
import java.util.List;

public class QuanLyNhanVien {
     List<NhanVien> nhanVienList = new ArrayList<>();
    public static final String FULL = "Fulltime";
    public static final String PART = "Parttime";

    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }

    public void setNhanVienList(List<NhanVien> nhanVienList) {
        this.nhanVienList = nhanVienList;
    }

    public void them (NhanVien nhanVien) {
        nhanVienList.add(nhanVien);
        System.out.println(ANSI_BLUE + "Bạn đã thêm thành công 1 nhân viên mới" + ANSI_RESET);
    }

    public void hienThi() {
        boolean check = false;
        for (int i=0; i<nhanVienList.size(); i++) {
            System.out.println(nhanVienList.get(i));
            check = true;
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Chưa có nhân viên nào được thêm mới!" + ANSI_RESET);
        }
    }

    public void timKiemTen(String ten) {  // Cái này trả về các vị trí(hiển thị luôn thông tin) phục vụ cho việc tìm kiếm theo tên nhập vào
        boolean check = false;
        for (int i=0; i<nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getTen().contains(ten)) {
                System.out.println(nhanVienList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Không có nhân viên này" + ANSI_RESET);
        }
    }

    public void timKiemCMND(int soCMND) {   // Cái này trả về vị trí(hiển thị luôn thông tin) phục vụ cho tìm kiếm theo số CMND
        boolean check = false;
        for (int i=0; i<nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getSoCMND() == soCMND) {
                System.out.println(nhanVienList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Không có nhân viên nào có số CMND này" + ANSI_RESET);
        }
    }

    public void timKiemFullTime() {   // Cái này trả về các vị trí(hiển thị luôn thông tin) phục vụ cho tìm kiếm theo Fulltime
        boolean check = false;
        for (int i=0; i<nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getLoai().equals(FULL)) {
                System.out.println(nhanVienList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Không có nhân viên làm Fulltime" + ANSI_RESET);
        }
    }

    public void timKiemPartTime() {  // Cái này trả về các vị trí(hiển thị luôn thông tin) phục vụ cho tìm kiếm theo Parttime
        boolean check = false;
        for (int i=0; i<nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getLoai().equals(PART)) {
                System.out.println(nhanVienList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Không có nhân viên làm Parttime" + ANSI_RESET);
        }
    }

    public int timKiemTen1(String ten) {  // Cái này trả về vị trí (chỉ vị trí ko hiển thị thông tin) phục vụ cho việc sửa theo tên nhập vào (chỉ có tác dụng khi tên là duy nhất)
        for (int i = 0; i < nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getTen().equals(ten)) {
                return i;
            }
        }
        return -1;
    }

    public void suaTen(String ten, NhanVien nhanVien) { // Cái này sửa theo tên nhập vào (chỉ có tác dụng khi tên là duy nhất)
        int indexOf = timKiemTen1(ten);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có Nhân viên này" + ANSI_RESET);
        } else {
            nhanVienList.set(indexOf, nhanVien);
            System.out.println(ANSI_BLUE + "Bạn đã sửa thành công thông tin của nhân viên trên"+ ANSI_RESET);
        }
    }

    public int timKiemsoCMND (int soCMND) {  // // Cái này trả về vị trí (chỉ vị trí ko hiển thị thông tin) phục vụ cho việc sửa theo số CMND nhập vào
        for (int i = 0; i < nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getSoCMND() == soCMND) {
               return i;
            }
        }
        return -1;
    }

    public void suasoCMND (int soCMND, NhanVien nhanVien) { // Cái này sửa theo số CMND nhập vào
        int indexOf = timKiemsoCMND(soCMND);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có Nhân viên nào có số CMND này" + ANSI_RESET);
        } else {
            nhanVienList.set(indexOf, nhanVien);
            System.out.println(ANSI_BLUE + "Bạn đã sửa thành công thông tin nhân viên trên" + ANSI_RESET);
        }
    }

    public void capNhatsoCMND (int soCMND) { // Cái này sửa theo số CMND nhập vào
        int indexOf = timKiemsoCMND(soCMND);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có Nhân viên nào có số CMND này" + ANSI_RESET);
        } else {
            nhanVienList.get(indexOf).setTrangThai("Thôi việc");
            nhanVienList.get(indexOf).setLuong(0);
            nhanVienList.get(indexOf).setLoai("Thôi việc");
            System.out.println(ANSI_BLUE + "Bạn đã cập nhật thành công!" + ANSI_RESET);
        }
    }

    public void luong() {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i=0; i<nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getLoai().contains("Fulltime")) {
                sum1 += nhanVienList.get(i).getLuong();
            }
        }
        System.out.println(ANSI_CYAN + "Tổng lương của nhân viên Fulltime là: " + sum1 + ANSI_RESET);

        for (int i=0; i<nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getLoai().contains("Parttime")) {
                sum2 += nhanVienList.get(i).getLuong();
            }
        }
        System.out.println(ANSI_CYAN + "Tổng lương của nhân viên Parttime là: " + sum2 + ANSI_RESET);


        for (int i=0; i<nhanVienList.size(); i++) {
                sum3 += nhanVienList.get(i).getLuong();
        }
        System.out.println(ANSI_CYAN + "Tổng lương của toàn bộ nhân viên là: " + sum3 + ANSI_RESET);

    }

    public void xoaTen (String ten) {
        int indexOf = timKiemTen1(ten);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có nhân viên nào có tên này!" + ANSI_RESET);
        } else {
            nhanVienList.remove(indexOf);
            System.out.println(ANSI_BLUE + "Nhân viên trên đã được xóa khỏi danh sách" + ANSI_RESET);
        }
    }

    public void xoasoCMND (int soCMND) {
        int indexOf = timKiemsoCMND(soCMND);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có nhân viên nào có số CMND này!"+ ANSI_RESET);
        } else {
            nhanVienList.remove(indexOf);
            System.out.println(ANSI_BLUE + "Nhân viên trên đã được xóa khỏi danh sách" + ANSI_RESET);
        }
    }



    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


}
