package latihan3;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.stream.Collectors;

class VehicleManagementSystem {
    public static void main(String[] args) {
        /*
         * REAL-WORLD PROJECT: Vehicle Rental Management System
         */

        List<Vehicle> vehicleFleet = new ArrayList<>();
        List<RentalTransaction> rentalHistory = new ArrayList<>();

        System.out.println("=== VEHICLE RENTAL MANAGEMENT SYSTEM ===\n");

        // -----------------------------------------------------------------
        // Latihan 1: Create vehicle fleet
        // -----------------------------------------------------------------
        System.out.println("## Latihan 1: Create Vehicle Fleet 🚗🛵");
        // - Buat 3 Mobil: Toyota Avanza, Honda Jazz, Suzuki Ertiga
        vehicleFleet.add(new Car("Toyota", "Avanza", 2020, "B 1234 ABC", 300000, 7, "Manual", true));
        vehicleFleet.add(new Car("Honda", "Jazz", 2018, "D 5678 EFG", 350000, 5, "Automatic", true));
        vehicleFleet.add(new Car("Suzuki", "Ertiga", 2021, "F 9012 HIJ", 280000, 7, "Manual", false));

        // - Buat 2 Motor: Honda Beat, Yamaha NMAX
        vehicleFleet.add(new Motorcycle("Honda", "Beat", 2022, "A 3456 KLM", 80000, "Matic", 110));
        vehicleFleet.add(new Motorcycle("Yamaha", "NMAX", 2023, "L 7890 NOP", 120000, "Matic", 155));

        System.out.println("Fleet created: " + vehicleFleet.size() + " vehicles\n");

        // -----------------------------------------------------------------
        // Latihan 2: Display all vehicles
        // -----------------------------------------------------------------
        System.out.println("## Latihan 2: Display All Vehicles 📋");
        for (Vehicle v : vehicleFleet) {
            v.displayInfo();
            System.out.println("---");
        }
        System.out.println();

        // -----------------------------------------------------------------
        // Latihan 3: Rent a vehicle
        // -----------------------------------------------------------------
        System.out.println("## Latihan 3: Rent a Vehicle 🔑");
        Vehicle avanza = vehicleFleet.get(0); // Toyota Avanza
        RentalTransaction rentalAndi = new RentalTransaction("Andi", avanza, 3);
        rentalHistory.add(rentalAndi);
        rentalAndi.displayRentalDetails();
        System.out.println();

        // -----------------------------------------------------------------
        // Latihan 4: Calculate monthly revenue
        // -----------------------------------------------------------------
        System.out.println("## Latihan 4: Calculate Monthly Revenue 💰");

        // Rent beberapa kendaraan tambahan untuk simulasi revenue
        Vehicle jazz = vehicleFleet.get(1); // Honda Jazz
        RentalTransaction rentalBudi = new RentalTransaction("Budi", jazz, 5);
        rentalHistory.add(rentalBudi);

        Vehicle beat = vehicleFleet.get(3); // Honda Beat
        RentalTransaction rentalCaca = new RentalTransaction("Caca", beat, 7);
        rentalHistory.add(rentalCaca);

        Vehicle nmax = vehicleFleet.get(4); // Yamaha NMAX
        RentalTransaction rentalDono = new RentalTransaction("Dono", nmax, 8);
        rentalHistory.add(rentalDono);

        // Simulasikan 3 rental Mobil (Total 3+5+7 = 15 hari) dan 2 rental Motor (Total 7+8 = 15 hari)
        // Hitung total revenue dari semua transaksi
        double totalRevenue = 0;
        for (RentalTransaction rt : rentalHistory) {
            totalRevenue += rt.getTotalBiaya();
        }

        String totalRevenueStr = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(totalRevenue).replace("Rp", "Rp ");
        System.out.println("Total revenue bulan ini: " + totalRevenueStr);
        System.out.println();

        // -----------------------------------------------------------------
        // Latihan 5: Vehicle maintenance
        // -----------------------------------------------------------------
        System.out.println("## Latihan 5: Vehicle Maintenance 🛠️");

        // Mark beberapa kendaraan sebagai "under maintenance"
        Vehicle ertiga = vehicleFleet.get(2); // Suzuki Ertiga
        ertiga.setTersedia(false); // Ertiga under maintenance

        // Hitung kendaraan yang tersedia dan tidak tersedia
        long availableCount = vehicleFleet.stream().filter(Vehicle::isTersedia).count();
        long unavailableCount = vehicleFleet.size() - availableCount;

        System.out.println("Available vehicles: " + availableCount);
        System.out.println("Under maintenance/Rented: " + unavailableCount);

        System.out.println("\n--- Available Vehicles Info ---");
        for (Vehicle v : vehicleFleet) {
            if (v.isTersedia()) {
                System.out.println("* " + v.getMerk() + " " + v.getModel());
            }
        }
        System.out.println();
        // Kembalikan Ertiga untuk Latihan 6 (simulasi)
        ertiga.setTersedia(true);

        // -----------------------------------------------------------------
        // Latihan 6: Find vehicles by criteria
        // -----------------------------------------------------------------
        System.out.println("## Latihan 6: Find Vehicles by Criteria 🔍");

        // - Find all Mobil dengan harga < Rp 350,000/hari
        List<Vehicle> filteredCars = vehicleFleet.stream()
                .filter(v -> v instanceof Car)
                .filter(v -> v.getHargaRentalPerHari() < 350000)
                .collect(Collectors.toList());

        System.out.println("Found " + filteredCars.size() + " Mobil (Harga < Rp 350,000/hari):");
        for (Vehicle v : filteredCars) {
            System.out.println("* " + v.getMerk() + " " + v.getModel() + " (" + v.formatRupiah(v.getHargaRentalPerHari()) + ")");
        }

        // - Find all Motor jenis "matic"
        List<Vehicle> filteredMotorcycles = vehicleFleet.stream()
                .filter(v -> v instanceof Motorcycle)
                .filter(v -> ((Motorcycle) v).getJenisMotor().equalsIgnoreCase("Matic"))
                .collect(Collectors.toList());

        System.out.println("\nFound " + filteredMotorcycles.size() + " Motor matic:");
        for (Vehicle v : filteredMotorcycles) {
            System.out.println("* " + v.getMerk() + " " + v.getModel());
        }
        System.out.println();

        // -----------------------------------------------------------------
        // Latihan 7: Generate rental report
        // -----------------------------------------------------------------
        System.out.println("## Latihan 7: Generate Rental Report 📊");

        double totalRevenueCar = 0;
        int countCar = 0;
        double totalRevenueMotorcycle = 0;
        int countMotorcycle = 0;

        for (RentalTransaction rt : rentalHistory) {
            if (rt.getKendaraan() instanceof Car) {
                totalRevenueCar += rt.getTotalBiaya();
                countCar++;
            } else if (rt.getKendaraan() instanceof Motorcycle) {
                totalRevenueMotorcycle += rt.getTotalBiaya();
                countMotorcycle++;
            }
        }

        String totalCarStr = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(totalRevenueCar).replace("Rp", "Rp ");
        String totalMotorcycleStr = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(totalRevenueMotorcycle).replace("Rp", "Rp ");
        String grandTotalStr = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(totalRevenue).replace("Rp", "Rp ");

        System.out.println("=== RENTAL REPORT ===");
        System.out.println("Mobil: " + countCar + " rentals, " + totalCarStr);
        System.out.println("Motor: " + countMotorcycle + " rentals, " + totalMotorcycleStr);
        System.out.println("Total: " + grandTotalStr);
    }
}