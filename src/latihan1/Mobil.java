package latihan1;

class Mobil extends Kendaraan {
    // Properties tambahan
    private int jumlahPintu;
    private String jenisBahanBakar;

    // Constructor
    public Mobil(String merk, String warna, int tahunProduksi, int jumlahPintu, String jenisBahanBakar) {
        // TODO: Panggil constructor parent dengan super()
        super(merk, warna, tahunProduksi);
        // TODO: Inisialisasi properties tambahan
        this.jumlahPintu = jumlahPintu;
        this.jenisBahanBakar = jenisBahanBakar;
        // TODO: Print "Constructor Mobil dipanggil"
        System.out.println("Constructor Mobil dipanggil");
    }

    // Override method displayInfo
    @Override
    public void displayInfo() {
        // TODO: Panggil super.displayInfo() terlebih dahulu
        super.displayInfo();
        // TODO: Tambahkan informasi spesifik Mobil
        System.out.println("Jumlah Pintu: " + jumlahPintu);
        System.out.println("Bahan Bakar: " + jenisBahanBakar);
    }

    // Method tambahan khusus Mobil
    public void nyalakanAC() {
        // TODO: Print "AC menyala"
        System.out.println("AC menyala");
    }

    // Getter
    public int getJumlahPintu() {
        return jumlahPintu;
    }
}