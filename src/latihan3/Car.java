package latihan3;

class Car extends Vehicle {
    // Properties tambahan
    private int jumlahPenumpang;
    private String tipeTransmisi; // "Manual", "Automatic"
    private boolean acTersedia;
    private static final double SURCHARGE_AC = 50000; // Surcharge AC per hari

    // Constructor
    public Car(String merk, String model, int tahunProduksi, String nomorPolisi,
               double hargaRentalPerHari, int jumlahPenumpang,
               String tipeTransmisi, boolean acTersedia) {
        super(merk, model, tahunProduksi, nomorPolisi, hargaRentalPerHari);
        this.jumlahPenumpang = jumlahPenumpang;
        this.tipeTransmisi = tipeTransmisi;
        this.acTersedia = acTersedia;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Detail Mobil:");
        System.out.println("    Penumpang: " + jumlahPenumpang);
        System.out.println("    Transmisi: " + tipeTransmisi);
        System.out.println("    AC: " + (acTersedia ? "Ya (Surcharge " + formatRupiah(SURCHARGE_AC) + ")" : "Tidak"));
    }

    // Override biaya rental (Car bisa punya surcharge)
    @Override
    public double hitungBiayaRental(int jumlahHari) {
        double biayaDasar = super.hitungBiayaRental(jumlahHari);
        double surcharge = 0;
        if (acTersedia) {
            surcharge = SURCHARGE_AC * jumlahHari;
        }
        return biayaDasar + surcharge;
    }

    // Getter untuk filter di Latihan 6
    public String getTipeTransmisi() {
        return tipeTransmisi;
    }
}