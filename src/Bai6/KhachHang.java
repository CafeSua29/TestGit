package Bai6;

public class KhachHang {
    private String maKhachHang;
    private GioiTinh gioiTinh;
    private int tuoi;

    public KhachHang() {

    }

    public KhachHang(String maKhachHang, GioiTinh gioiTinh, int tuoi) {
        this.maKhachHang = maKhachHang;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
