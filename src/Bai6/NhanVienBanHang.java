package Bai6;

public class NhanVienBanHang {
    private String maNV;
    private GioiTinh gioiTinh;
    private int[] ngayLamViec;
    private CaLam caDangKy;

    public NhanVienBanHang() {

    }

    public NhanVienBanHang(int soNgayLamViec) {
        ngayLamViec = new int[soNgayLamViec];
    }

    public NhanVienBanHang(String maNV, GioiTinh gioiTinh, int[] ngayLamViec, CaLam caDangKy) {
        this.maNV = maNV;
        this.gioiTinh = gioiTinh;
        this.ngayLamViec = ngayLamViec;
        this.caDangKy = caDangKy;
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

    public CaLam getCaDangKy() {
        return caDangKy;
    }

    public void setCaDangKy(CaLam caDangKy) {
        this.caDangKy = caDangKy;
    }
}
