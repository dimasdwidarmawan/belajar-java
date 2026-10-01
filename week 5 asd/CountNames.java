import java.util.*;
import java.util.LinkedHashMap;

public class CountNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Deklarasikan Map untuk menyimpan pasangan Nama (String) dan Jumlah/Count
        // (Integer)
        Map<String, Integer> nameCounts = new LinkedHashMap<>();

        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();

            // 2. Cek jika pengguna menekan Enter (string kosong)
            if (name.isEmpty()) {
                break;
            }

            // 3. Masukkan nama ke dalam Map dan perbarui jumlahnya
            if (nameCounts.containsKey(name)) {
                // Jika sudah ada, ambil nilai lama lalu tambahkan 1
                nameCounts.put(name, nameCounts.get(name) + 1);
            } else {
                // Jika belum ada, masukkan nama dengan count awal 1
                nameCounts.put(name, 1);
            }
        }

        // 4. Cetak hasil hitungan
        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            System.out.println("Entry [" + entry.getKey() + "] has count " + entry.getValue());
        }

        scanner.close();
    }
}