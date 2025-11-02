package latihan3;

import java.util.Locale;
import java.text.NumberFormat;

public class Vehicle {
    // Properties
    protected String merk;
    protected String model;
    protected int tahunProduksi;
    protected String nomorPolisi;
    protected double hargaRentalPerHari;
    protected boolean tersedia;

    // Constructor
    public Vehicle(String merk, String model, int tahunProduksi,
                   String nomorPolisi, double hargaRentalPerHari) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.nomorPolisi = nomorPolisi;
        this.hargaRentalPerHari = hargaRentalPerHari;
        this.tersedia = true; // Default: tersedia saat dibuat
    }

    // Method untuk rental
    public double hitungBiayaRental(int jumlahHari) {
        return this.hargaRentalPerHari * jumlahHari;
    }

    // Method displayInfo
    public void displayInfo() {
        System.out.println("  Kendaraan: " + merk + " " + model + " (" + tahunProduksi + ")");
        System.out.println("  Tipe: " + this.getClass().getSimpleName());
        System.out.println("  No. Polisi: " + nomorPolisi);
        System.out.println("  Harga/Hari: " + formatRupiah(hargaRentalPerHari));
        System.out.println("  Status: " + (tersedia ? "Tersedia" : "Maintenance/Disewa"));
    }

    // Helper method untuk format mata uang
    protected String formatRupiah(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        return formatter.format(amount).replace("Rp", "Rp ");
    }

    // Getters and setters
    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public double getHargaRentalPerHari() {
        return hargaRentalPerHari;
    }

    public String getMerk() {
        return merk;
    }

    public String getModel() {
        return model;
    }
}