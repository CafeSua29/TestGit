package Bai6;

public class NhanVienNhapHang {
    private String maNV;
    private GioiTinh gioiTinh;
    private int[] ngayLamViec;
    private int thamNien;

    public NhanVienNhapHang() {

    }

    public NhanVienNhapHang(int soNgayLamViec) {
        ngayLamViec = new int[soNgayLamViec];
    }

    public NhanVienNhapHang(String maNV, GioiTinh gioiTinh, int[] ngayLamViec, int thamNien) {
        this.maNV = maNV;
        this.gioiTinh = gioiTinh;
        this.ngayLamViec = ngayLamViec;
        this.thamNien = thamNien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int[] getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(int[] ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public int getThamNien() {
        return thamNien;
    }

    public void setThamNien(int thamNien) {
        this.thamNien = thamNien;
    }
}
