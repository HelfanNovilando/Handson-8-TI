package latihan3;

import java.util.Locale;
import java.text.NumberFormat;

class RentalTransaction {
    // Properties
    private String namaPelanggan;
    private Vehicle kendaraan;
    private int durasiHari;
    private double totalBiaya;

    // Constructor
    public RentalTransaction(String namaPelanggan, Vehicle kendaraan, int durasiHari) {
        this.namaPelanggan = namaPelanggan;
        this.kendaraan = kendaraan;
        this.durasiHari = durasiHari;
        // Hitung total biaya menggunakan method dari Vehicle (Polymorphism)
        this.totalBiaya = kendaraan.hitungBiayaRental(durasiHari);
        // Tandai kendaraan tidak tersedia
        kendaraan.setTersedia(false);
    }

    // Method display rental details
    public void displayRentalDetails() {
        System.out.println("Rental untuk: " + namaPelanggan);
        System.out.println("Kendaraan: " + kendaraan.getMerk() + " " + kendaraan.getModel() + " (" + kendaraan.getClass().getSimpleName() + ")");
        System.out.println("Durasi: " + durasiHari + " hari");
        // Gunakan formatRupiah dari Vehicle
        String biayaPerHariStr = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(kendaraan.getHargaRentalPerHari()).replace("Rp", "Rp ");
        System.out.println("Biaya per hari: " + biayaPerHariStr);
        String totalBiayaStr = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(totalBiaya).replace("Rp", "Rp ");
        System.out.println("Total biaya: " + totalBiayaStr);
    }

    // Getters
    public double getTotalBiaya() {
        return totalBiaya;
    }

    public Vehicle getKendaraan() {
        return kendaraan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }
}