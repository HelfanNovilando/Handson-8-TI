package latihan1;

public class BasicInheritancePractice {
    public static void main(String[] args) {
        // ===== INHERITANCE DASAR =====
        System.out.println("=== INHERITANCE DASAR ===");

        // Latihan 1: Membuat hierarki kendaraan sederhana
        // - Buat object dari class Mobil dengan parameter:
        //   merk: "Toyota", warna: "Hitam", tahun: 2022, jumlahPintu: 4, jenisBahanBakar: "Bensin"
        // - Panggil method displayInfo()
        // - Panggil method nyalakanAC()
        Mobil mobilToyota = new Mobil("Toyota", "Hitam", 2022, 4, "Bensin");
        mobilToyota.displayInfo();
        mobilToyota.nyalakanAC();

        // Latihan 2: Membuat hierarki kendaraan Motor
        // - Buat object dari class Motor dengan parameter:
        //   merk: "Honda", warna: "Merah", tahun: 2023, jenisMotor: "Sport"
        // - Panggil method displayInfo()
        // - Panggil method klakson()
        // - Panggil method lakukanWheely()
        Motor motorHonda = new Motor("Honda", "Merah", 2023, "Sport");
        motorHonda.displayInfo();
        motorHonda.klakson();
        motorHonda.lakukanWheely();

        // ===== PENGGUNAAN SUPER =====
        System.out.println("\n=== PENGGUNAAN SUPER ===");

        // Latihan 3: Memanggil constructor parent
        // - Buat object Truk dengan parameter:
        //   merk: "Mitsubishi", warna: "Putih", tahun: 2021, kapasitasMuatan: 5.0, jumlahRoda: 6
        // - Panggil method displayInfo()
        Truk trukMitsubishi = new Truk("Mitsubishi", "Putih", 2021, 5.0, 6);
        trukMitsubishi.displayInfo();

        // Latihan 4: Mengakses method parent dengan super
        // - Panggil method klakson() dari object Truk
        // - Method klakson() di Truk harus memanggil super.klakson() terlebih dahulu
        // - Kemudian tambahkan suara klakson truk yang lebih keras
        trukMitsubishi.klakson();

        // ===== MULTILEVEL INHERITANCE =====
        System.out.println("\n=== MULTILEVEL INHERITANCE ===");

        // Latihan 5: Membuat hierarki 3 level
        // - Buat object MobilSport dengan parameter:
        //   merk: "Ferrari", warna: "Merah", tahun: 2024, jumlahPintu: 2,
        //   jenisBahanBakar: "Bensin", turbo: true, kecepatanMaksimal: 320
        // - Panggil method displayInfo()
        // - Panggil method aktifkanTurbo()
        MobilSport mobilSportFerrari = new MobilSport("Ferrari", "Merah", 2024,
                2, "Bensin",
                true, 320);
        mobilSportFerrari.displayInfo();
        mobilSportFerrari.aktifkanTurbo();

        // ===== TESTING INHERITANCE =====
        System.out.println("\n=== TESTING INHERITANCE ===");

        // Latihan 6: Menggunakan instanceof
        // - Cek apakah mobilSport instanceof MobilSport
        // - Cek apakah mobilSport instanceof Mobil
        // - Cek apakah mobilSport instanceof Kendaraan
        // - Cek apakah mobilSport instanceof Object
        System.out.println("mobilSport instanceof MobilSport: " + (mobilSportFerrari instanceof MobilSport));
        System.out.println("mobilSport instanceof Mobil: " + (mobilSportFerrari instanceof Mobil));
        System.out.println("mobilSport instanceof Kendaraan: " + (mobilSportFerrari instanceof Kendaraan));
        System.out.println("mobilSport instanceof Object: " + (mobilSportFerrari instanceof Object));

        // Latihan 7: Akses level dan inheritance
        // - Coba akses property protected (merk, warna, tahunProduksi) dari child class -> BISA
        // - Coba akses property private (nomorRangka) langsung dari child class -> TIDAK BISA
        // - Gunakan getter untuk akses private property
        // Kita set nomorRangka dulu untuk diakses via getter
        mobilSportFerrari.setNomorRangka("FRR2024001");

        // Akses protected properties langsung dari child class (di BasicInheritancePractice)
        System.out.println("Protected property (merk): " + mobilSportFerrari.merk);
        // Note: Protected property dapat diakses langsung karena BasicInheritancePractice berada dalam package yang sama
        // atau jika class ini adalah subclass (yang tidak terjadi di sini, tapi umumnya protected bisa diakses dari class
        // dalam package yang sama, atau dari subclass di manapun).

        // Akses private property via getter
        System.out.println("Private property via getter (nomorRangka): " + mobilSportFerrari.getNomorRangka());
        // Jika kita mencoba: System.out.println(mobilSportFerrari.nomorRangka);
        // akan menghasilkan Compile Error karena nomorRangka adalah private.
    }
}