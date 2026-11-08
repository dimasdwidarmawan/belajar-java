class Sorting {
    int data[];

    Sorting(int[] a) {
        this.data = a;
    }

    public String toString() {
        String output = "";
        for (int d : data)
            output += " " + d;
        return output;
    }

    // buble sort
    void bubleSort() {
        for (int s = this.data.length - 2; s >= 0; s--) {
            for (int p = 0; p <= s; p++) {
                if (this.data[p + 1] < this.data[p]) {
                    // swap
                    int temp = this.data[p + 1];
                    this.data[p + 1] = this.data[p];
                    this.data[p] = temp;
                }
            }
        }
    }

    // selection sort
    void selectionSort() {
        for (int p = 0; p < this.data.length - 1; p++) {
            int min = Integer.MAX_VALUE;
            int minIdx = p + 1;

            for (int i = p + 1; i < this.data.length; i++) {
                if (this.data[i] < min) {
                    min = this.data[i];
                    minIdx = i;
                }
            }

            if (min < this.data[p]) {
                // swap
                int t = this.data[p];
                this.data[p] = min;
                this.data[min] = t;
            }
        }
    }

    // insertion sort
    void insertionSort() {
        for (int p = 1; p < this.data.length; p++) {
            int temp = this.data[p];
            boolean stop = false;
            for (int i = p - 1; i >= 0 && !stop; i--) {
                if (this.data[i] > temp) {
                    this.data[i + 1] = this.data[i];
                    this.data[i] = temp;
                } else {
                    stop = true;
                }
            }
        }
    }

    // Merge Sort
    void mergeSort() {
        // Memulai proses divide-and-conquer dengan memanggil method split
        // dari indeks awal (0) hingga indeks terakhir (data.length - 1).
        if (this.data != null && this.data.length > 1) {
            split(this.data, 0, this.data.length - 1);
        }
    }

    // Split the array into two subarrays, sort them and merge them
    void split(int arr[], int l, int r) {
        if (l < r) {
            // m adalah titik tengah untuk membagi array menjadi dua sub-array
            int m = (l + r) / 2;

            split(arr, l, m);
            split(arr, m + 1, r);

            // Menggabungkan kembali sub-array yang sudah terurut
            merge(arr, l, m, r);
        }
    }

    // Merge two subarrays L and M into arr
    void merge(int arr[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    // Mengubah urutan array dari ascending menjadi descending (kebalikan)
    void reverse() {
        int r[] = new int[this.data.length];
        int l = this.data.length - 1;

        // Melakukan iterasi untuk menyalin elemen dari data asli ke array baru 'r'
        // secara terbalik (dari belakang ke depan).
        for (int i = 0; i < this.data.length; i++) {
            r[i] = this.data[l - i];
        }

        this.data = r; // Mengarahkan referensi data ke array yang sudah dibalik
    }

    int linearSearch(int k) {
        return linearSearch(k, 0);
    }

    // Implementasi rekursif untuk Linear Search
    int linearSearch(int k, int i) {
        // Base case: Jika index mencapai panjang array dan nilai tidak ditemukan,
        // kembalikan -1
        if (i == this.data.length) {
            return -1;
        }
        // Recursive step: Jika nilai pada index ke-i sama dengan k, kembalikan index i
        else if (this.data[i] == k) {
            return i;
        }
        // Jika belum ketemu, lanjutkan pencarian ke index berikutnya (i + 1) secara
        // rekursif
        else {
            return linearSearch(k, i + 1);
        }
    }

    int binarySearch(int k) {
        return binarySearch(k, 0, this.data.length - 1);
    }

    // Implementasi rekursif untuk Binary Search (membutuhkan data yang sudah
    // terurut)
    int binarySearch(int k, int l, int h) {
        // Base case: Jika batas bawah melebihi batas atas, berarti elemen tidak ada
        if (l > h)
            return -1;

        // Recursive step
        else {
            int m = (l + h) / 2;
            int v = this.data[m];

            // Jika nilai tengah sama dengan yang dicari, kembalikan indeks m
            if (v == k) {
                return m;
            }
            // Jika nilai tengah lebih besar dari k, cari di paruh sebelah kiri (l sampai m
            // - 1)
            else if (v > k) {
                return binarySearch(k, l, m - 1);
            }
            // Jika nilai tengah lebih kecil dari k, cari di paruh sebelah kanan (m + 1
            // sampai h)
            else {
                return binarySearch(k, m + 1, h);
            }
        }
    }
}