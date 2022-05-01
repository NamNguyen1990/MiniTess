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
    }

    public void hienThi() {
        boolean check = false;
        for (int i=0; i<nhanVienList.size(); i++) {
            System.out.println(nhanVienList.get(i));
            check = true;
        }
        if (check == false) {
            System.out.println("Chưa có nhân viên nào được thêm mới!");
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
            System.out.println("Không có nhân viên này");
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
            System.out.println("Không có nhân viên này");
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
            System.out.println("Không có nhân viên làm Fulltime");
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
            System.out.println("Không có nhân viên làm Parttime");
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
            System.out.println("Không có Nhân viên này");
        } else {
            nhanVienList.set(indexOf, nhanVien);
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
            System.out.println("Không có Nhân viên nào có số CMND này");
        } else {
            nhanVienList.set(indexOf, nhanVien);
        }
    }

    public void capNhatsoCMND (int soCMND) { // Cái này sửa theo số CMND nhập vào
        int indexOf = timKiemsoCMND(soCMND);
        if (indexOf == -1) {
            System.out.println("Không có Nhân viên nào có số CMND này");
        } else {
            nhanVienList.get(indexOf).setTrangThai("Thôi việc");
            nhanVienList.get(indexOf).setLuong(0);
            nhanVienList.get(indexOf).setLoai("Thôi việc");
        }
    }


















}
