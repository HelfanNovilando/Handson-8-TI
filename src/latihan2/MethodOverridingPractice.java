package latihan2;

public class MethodOverridingPractice {
    public static void main(String[] args) {
        // ===== BASIC METHOD OVERRIDING =====
        System.out.println("=== BASIC METHOD OVERRIDING ===");

        // Latihan 1: Override method toString()
        // - Buat object Mahasiswa
        Mahasiswa m1 = new Mahasiswa("2024001", "Budi", "Informatika", 3.75);
        // - Print object menggunakan toString()
        System.out.println("Latihan 1 Output: " + m1);

        // Latihan 2: Override method equals()
        // - Buat dua object Mahasiswa dengan NIM yang sama
        Mahasiswa m2 = new Mahasiswa("2024001", "Ani", "Sistem Informasi", 3.50);
        // - Compare menggunakan equals()
        System.out.println("Latihan 2 - m1.equals(m2): " + m1.equals(m2) + " (karena NIM sama)");
        // - Compare menggunakan == (reference equality)
        System.out.println("Latihan 2 - m1 == m2: " + (m1 == m2) + " (referensi berbeda)");

        // ===== OVERRIDING WITH SUPER =====
        System.out.println("\n=== OVERRIDING WITH SUPER ===");

        // Latihan 3: Override dengan memanggil super
        // - Buat object Dosen
        Dosen d1 = new Dosen("198901001", "Dr. Sarah", "Informatika", "PBO", 10);
        // - Panggil method displayInfo()
        System.out.println("Latihan 3 Output:");
        d1.displayInfo();

        // Latihan 4: Chain of overriding
        // - Buat object DosenProfessor
        DosenProfessor dp1 = new DosenProfessor("198002002", "Prof. Joni", "Informatika",
                "Struktur Data", 20, "Prof. Dr.", 50);
        // - Test chain dari Pegawai -> Dosen -> DosenProfessor
        System.out.println("Latihan 4 Output:");
        dp1.displayInfo(); // Output sudah termasuk constructor messages dari chain

        // ===== COVARIANT RETURN TYPES =====
        System.out.println("\n=== COVARIANT RETURN TYPES ===");

        // Latihan 5: Return type yang lebih spesifik
        // Parent return type: Pegawai, Child return type: Dosen (covariant)
        Dosen d2 = new Dosen("199503003", "Bambang", "Matematika", "Aljabar", 5);
        Dosen d2_clone = d2.clone(); // Memanggil Dosen.clone(), return type Dosen
        System.out.println("Latihan 5 Output:");
        System.out.println("Clone berhasil dengan type yang lebih spesifik");
        System.out.println("d2 != d2_clone (referensi berbeda): " + (d2 != d2_clone));
        System.out.println("d2.equals(d2_clone) (konten sama): " + d2.equals(d2_clone));

        // ===== OVERRIDING RULES =====
        System.out.println("\n=== OVERRIDING RULES ===");

        // Latihan 6: Access modifier rules
        // - Test: protected -> public (VALID)
        System.out.print("Latihan 6 - Widening access modifier (protected -> public): ");
        Dosen d3 = new Dosen("0", "Test", "Test", "Test", 0);
        d3.methodProtected(); // Berhasil dipanggil karena di-override menjadi public
        System.out.println("Widening access modifier: ALLOWED");

        // - Test: public -> protected (INVALID - compile error)
        // Jika kita membuat method `public void calculateSalary()` di Pegawai dan
        // mencoba meng-override-nya dengan `protected void calculateSalary()` di Dosen:
        // System.out.println("Latihan 6 - Narrowing access modifier (public -> protected): COMPILE ERROR");
        // Akan terjadi error kompilasi, sehingga tidak bisa didemonstrasikan di runtime.

        // Latihan 7: Return type rules
        Pegawai p_test = new Pegawai("0", "Test", "Test");
        // Test: Same return type (sudah dilakukan di displayInfo, void -> void)
        // Test: Covariant return type (sudah dilakukan di clone, Pegawai -> Dosen)
        System.out.println("Latihan 7 - Same return type (displayInfo): VALID");
        System.out.println("Latihan 7 - Covariant return type (clone): VALID");
        // Test: Unrelated return type (ERROR)
        // Jika Dosen.clone() mengembalikan String, maka akan terjadi error kompilasi:
        // System.out.println("Latihan 7 - Unrelated return type (Pegawai -> String): COMPILE ERROR");

        // Latihan 8: Final method
        // PegawaiFinal p_final = new PegawaiFinal("0", "Final", "Final");
        // p_final.calculateSalary(); // Panggilan method final
        // System.out.println("Latihan 8 - Cannot override final method: COMPILE ERROR");
        // Untuk mendemonstrasikan, buat class DosenFinal yang extends PegawaiFinal
        // dan coba override calculateSalary() akan menghasilkan compile error.
        Pegawai p_final = new Pegawai("0", "Final", "Final");
        p_final.calculateSalary();
        System.out.println("Latihan 8 - Method calculateSalary() di Pegawai adalah final, tidak dapat di-override.");
    }
}