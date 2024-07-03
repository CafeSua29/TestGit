package Bai6;

import java.util.Date;
import java.util.List;

public class HoaDon {
    private String maHoaDon;
    private String maNVBanHang;
    private String maKhachHang;
    private List<String> danhSachMatHang;
    private double tongGia;
    private Date ngayMua;

    private HoaDon(){
        ngayMua = new Date();
    }

    public HoaDon(String maHoaDon, String maNVBanHang, String maKhachHang, List<String> danhSachMatHang, double tongGia) {
        this.maHoaDon = maHoaDon;
        this.maNVBanHang = maNVBanHang;
        this.maKhachHang = maKhachHang;
        this.danhSachMatHang = danhSachMatHang;
        this.tongGia = tongGia;
        ngayMua = new Date();
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNVBanHang() {
        return maNVBanHang;
    }

    public void setMaNVBanHang(String maNVBanHang) {
        this.maNVBanHang = maNVBanHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public List<String> getDanhSachMatHang() {
        return danhSachMatHang;
    }

    public void setDanhSachMatHang(List<String> danhSachMatHang) {
        this.danhSachMatHang = danhSachMatHang;
    }

    public double getTongGia() {
        return tongGia;
    }

    public void setTongGia(double tongGia) {
        this.tongGia = tongGia;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }
}
