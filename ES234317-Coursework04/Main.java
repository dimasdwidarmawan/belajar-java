
/**
 * ES234317 - Algorithms and Data Structures
 * Gasal | 2024-2025
 * Coursework   : 04
 * Student ID   : 5026251058
 * Full Name    : Dimas Dwi Darmawan
 * Class        : C
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Problem Test Case 1:");
        Integer[] a = { 1, 3, 1, 4, 3, 7, -2, 0, 7, -2, -2, 1 };
        ArrayList<Integer> v = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(twice(v));

        System.out.println("Problem Test Case 2:");
        String[] fNames = { "Marty", "Stuart", "Jessica", "Amanda", "Meghan", "Hal" };
        String[] lNames = { "Stepp", "Reges", "Miller", "Camp", "Miller", "Perkins" };
        String[] lNamesX = { "Stepp", "Reges", "Muller", "Camp", "Miller", "Perkins" };

        TreeMap<String, String> m1 = new TreeMap<String, String>();
        for (int i = 0; i < fNames.length; i++) {
            m1.put(fNames[i], lNames[i]);
        }

        TreeMap<String, String> m2 = new TreeMap<String, String>();
        for (int i = 0; i < fNames.length; i++) {
            m2.put(fNames[i], lNamesX[i]);
        }

        System.out.println(hasDuplicateValue(m1));
        System.out.println(hasDuplicateValue(m2));

        System.out.println("Problem Test Case 3:");
        Integer d1[] = { 3, 8, 17, 9, 17, 8, 3 };
        Integer d2[] = { 3, 8, 17, 9, 4, 17, 8, 3 };

        Queue<Integer> q1 = new LinkedList<Integer>(Arrays.asList(d1));
        Queue<Integer> q2 = new LinkedList<Integer>(Arrays.asList(d2));

        System.out.println(isPalindrome(q1));
        System.out.println(isPalindrome(q2));
    }

    /**
     * Menerima List integer dan mengembalikan Set berisi angka yang muncul tepat
     * dua kali.
     * Menggunakan Set bantu untuk melacak frekuensi kemunculan angka.
     */
    public static Set<Integer> twice(List<Integer> l) {
        Set<Integer> s = new TreeSet<Integer>();

        Set<Integer> seenOnce = new HashSet<>();
        Set<Integer> seenTwice = new HashSet<>();
        Set<Integer> seenMore = new HashSet<>();

        for (int num : l) {
            if (seenMore.contains(num)) {
                continue;
            } else if (seenTwice.contains(num)) {
                seenTwice.remove(num);
                seenMore.add(num);
            } else if (seenOnce.contains(num)) {
                seenTwice.add(num);
            } else {
                seenOnce.add(num);
            }
        }

        // Memasukkan hasil elemen yang muncul tepat dua kali ke dalam TreeSet s
        s.addAll(seenTwice);
        return s;
    }

    /**
     * Menerima Map dari String ke String, mengembalikan true jika ada
     * dua key berbeda yang memetakan ke value yang sama.
     */
    public static boolean hasDuplicateValue(Map<String, String> m) {
        boolean s = false;

        // Jika map kosong atau hanya memiliki 1 elemen, tidak ada duplikat
        if (m == null || m.size() <= 1) {
            return false;
        }

        Set<String> seenValues = new HashSet<>();
        for (String val : m.values()) {
            if (seenValues.contains(val)) {
                return true; // Ditemukan value yang sama
            }
            seenValues.add(val);
        }

        return s;
    }

    /**
     * Menerima Queue integer, mengembalikan true jika elemen-elemennya merupakan
     * palindrom.
     * Menggunakan satu Stack bantu dan mengembalikan queue ke urutan semula setelah
     * diperiksa.
     */
    public static boolean isPalindrome(Queue<Integer> q) {
        boolean s = true;

        // Queue kosong atau 1 elemen dianggap sebagai palindrom
        if (q == null || q.size() <= 1) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int size = q.size();

        // Langkah 1: Pindahkan elemen queue ke stack sekaligus mengembalikannya ke
        // queue
        // agar urutan di queue tetap terjaga dan stack tersusun secara terbalik
        for (int i = 0; i < size; i++) {
            int val = q.remove();
            stack.push(val);
            q.add(val);
        }

        // Langkah 2: Bandingkan elemen queue (urutan asli) dengan stack (urutan
        // terbalik)
        for (int i = 0; i < size; i++) {
            int qVal = q.remove();
            int sVal = stack.pop();

            if (qVal != sVal) {
                s = false;
            }
            // Kembalikan elemen ke queue untuk memulihkan kondisi aslinya
            q.add(qVal);
        }

        return s;
    }
}