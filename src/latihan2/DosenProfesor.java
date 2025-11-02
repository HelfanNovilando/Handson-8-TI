
package latihan2;

class DosenProfessor extends Dosen {
    // Properties tambahan
    private String gelarProfesor;
    private int jumlahPenelitian;

    // Constructor
    public DosenProfessor(String nip, String nama, String jurusan,
                          String mataKuliah, int pengalamanMengajar,
                          String gelarProfesor, int jumlahPenelitian) {
        super(nip, nama, jurusan, mataKuliah, pengalamanMengajar);
        this.gelarProfesor = gelarProfesor;
        this.jumlahPenelitian = jumlahPenelitian;
        // System.out.println("DosenProfessor constructor called"); // Tambahkan untuk Latihan 4
    }

    // Override displayInfo (chain dari Dosen) (Latihan 4)
    @Override
    public void displayInfo() {
        System.out.println("=== Info Dosen Professor ==="); // Judul baru
        // Kita bisa panggil super.displayInfo() atau langsung Pegawai.displayInfo()
        // Untuk chain yang benar, panggil super:
        super.displayInfo(); // Panggil Dosen.displayInfo() yang akan memanggil Pegawai.displayInfo()
        System.out.println("Gelar Profesor: " + gelarProfesor);
        System.out.println("Jumlah Penelitian: " + jumlahPenelitian);
    }
}