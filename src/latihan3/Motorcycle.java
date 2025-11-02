package latihan3;

class Motorcycle extends Vehicle {
    // Properties tambahan
    private String jenisMotor; // "Sport", "Matic", "Bebek"
    private int kapasitasMesin; // dalam CC

    // Constructor
    public Motorcycle(String merk, String model, int tahunProduksi,
                      String nomorPolisi, double hargaRentalPerHari,
                      String jenisMotor, int kapasitasMesin) {
        super(merk, model, tahunProduksi, nomorPolisi, hargaRentalPerHari);
        this.jenisMotor = jenisMotor;
        this.kapasitasMesin = kapasitasMesin;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Detail Motor:");
        System.out.println("    Jenis: " + jenisMotor);
        System.out.println("    Mesin: " + kapasitasMesin + " CC");
    }

    // Override biaya rental (contoh: Motor dapat diskon 10%)
    @Override
    public double hitungBiayaRental(int jumlahHari) {
        double biayaDasar = super.hitungBiayaRental(jumlahHari);
        // Contoh diskon 10% untuk Motor
        double diskon = biayaDasar * 0.10;
        return biayaDasar - diskon;
    }

    // Getter untuk filter di Latihan 6
    public String getJenisMotor() {
        return jenisMotor;
    }
}