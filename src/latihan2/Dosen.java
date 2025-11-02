package latihan2;

class Dosen extends Pegawai {
    // Properties tambahan
    private String mataKuliah;
    private int pengalamanMengajar;

    // Constructor
    public Dosen(String nip, String nama, String jurusan,
                 String mataKuliah, int pengalamanMengajar) {
        super(nip, nama, jurusan);
        this.mataKuliah = mataKuliah;
        this.pengalamanMengajar = pengalamanMengajar;
        // System.out.println("Dosen constructor called"); // Tambahkan untuk Latihan 4
    }

    // Override displayInfo (Latihan 3)
    @Override
    public void displayInfo() {
        super.displayInfo(); // Panggil implementasi parent
        System.out.println("Mata Kuliah: " + mataKuliah);
        System.out.println("Pengalaman: " + pengalamanMengajar + " tahun");
    }

    // Override clone dengan covariant return type (Latihan 5)
    @Override
    public Dosen clone() { // Return type Dosen, bukan Pegawai
        return new Dosen(this.nip, this.nama, this.jurusan,
                this.mataKuliah, this.pengalamanMengajar);
    }

    // Override dengan widening access (Latihan 6)
    @Override
    public void methodProtected() { // Access modifier dari protected menjadi public (Widening)
        System.out.println("Public method in Dosen (Overriding protected Pegawai method)");
    }
}