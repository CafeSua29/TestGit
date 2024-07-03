package Bai6;

public class MatHang {
    private String maHanghoa;
    private String tenHanghoa;
    private LoaiHang phanLoai;
    private double gia;

    public MatHang() {

    }

    public MatHang(String maHanghoa, String tenHanghoa, LoaiHang phanLoai, double gia) {
        this.maHanghoa = maHanghoa;
        this.tenHanghoa = tenHanghoa;
        this.phanLoai = phanLoai;
        this.gia = gia;
    }

    public String getMaHanghoa() {
        return maHanghoa;
    }

    public void setMaHanghoa(String maHanghoa) {
        this.maHanghoa = maHanghoa;
    }

    public String getTenHanghoa() {
        return tenHanghoa;
    }

    public void setTenHanghoa(String tenHanghoa) {
        this.tenHanghoa = tenHanghoa;
    }

    public LoaiHang getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(LoaiHang phanLoai) {
        this.phanLoai = phanLoai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
