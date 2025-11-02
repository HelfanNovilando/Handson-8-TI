package latihan1;

class Truk extends Kendaraan {
    // Properties tambahan
    private double kapasitasMuatan; // dalam ton
    private int jumlahRoda;

    // Constructor
    public Truk(String merk, String warna, int tahunProduksi, double kapasitasMuatan, int jumlahRoda) {
        // TODO: Implementasi constructor
        super(merk, warna, tahunProduksi);
        this.kapasitasMuatan = kapasitasMuatan;
        this.jumlahRoda = jumlahRoda;
        System.out.println("Constructor Truk dipanggil");
    }

    // Override method
    @Override
    public void displayInfo() {
        // TODO: Override dan tambahkan info Truk
        super.displayInfo();
        System.out.println("Kapasitas Muatan: " + kapasitasMuatan + " ton");
        System.out.println("Jumlah Roda: " + jumlahRoda);
    }

    @Override
    public void klakson() {
        // TODO: Panggil super.klakson() dulu
        super.klakson();
        // TODO: Kemudian print "HONK HONK! (suara klakson truk yang lebih keras)"
        System.out.println("HONK HONK! (suara klakson truk yang lebih keras)");
    }
}