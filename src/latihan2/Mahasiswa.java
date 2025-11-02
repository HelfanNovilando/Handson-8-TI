package latihan2;
import java.util.Objects;
class Mahasiswa {
    // Properties
    private String nim;
    private String nama;
    private String jurusan;
    private double ipk;

    // Constructor
    public Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Override toString (Latihan 1)
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                ", ipk=" + ipk +
                '}';
    }

    // Override equals - compare by NIM (Latihan 2)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mahasiswa other = (Mahasiswa) obj;
        return Objects.equals(nim, other.nim); // Implementasi equals berdasarkan NIM
    }

    // Override hashCode (best practice dengan equals) (Latihan 2)
    @Override
    public int hashCode() {
        return Objects.hash(nim); // Return hash dari NIM
    }
}