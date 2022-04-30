package quanlynhanvien;

import java.util.ArrayList;
import java.util.List;

public class QuanLyNhanVien {
     List<NhanVien> nhanVienList = new ArrayList<>();

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
}
