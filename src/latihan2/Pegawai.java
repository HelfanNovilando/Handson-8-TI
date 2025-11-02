package latihan2;
import java.util.Objects;

class Pegawai {
    // Properties
    protected String nip;
    protected String nama;
    protected String jurusan;

    // Constructor
    public Pegawai(String nip, String nama, String jurusan) {
        this.nip = nip;
        this.nama = nama;
        this.jurusan = jurusan;
        // System.out.println("Pegawai constructor called"); // Tambahkan untuk Latihan 4
    }

    // Method untuk di-override
    public void displayInfo() {
        System.out.println("=== Info Pegawai ===");
        System.out.println("NIP: " + nip);
        System.out.println("Nama: " + nama);
        System.out.println("Jurusan: " + jurusan);
    }

    // Method clone dengan return type Pegawai
    public Pegawai clone() {
        // Latihan 5 - Membuat shallow copy yang cukup untuk contoh ini
        return new Pegawai(this.nip, this.nama, this.jurusan);
    }

    // Protected method untuk ditest widening
    protected void methodProtected() {
        System.out.println("Protected method in Pegawai");
    }

    // Final method - tidak bisa di-override
    public final void calculateSalary() {
        System.out.println("Menghitung gaji pegawai...");
    }

    @Override
    public String toString() {
        return "Pegawai{" +
                "nip='" + nip + '\'' +
                ", nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                '}';
    }

    // Tambahan untuk Latihan 5: agar equals() di Dosen bisa membandingkan
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pegawai pegawai = (Pegawai) o;
        return Objects.equals(nip, pegawai.nip); // Bandingkan berdasarkan NIP
    }

    @Override
    public int hashCode() {
        return Objects.hash(nip);
    }
}