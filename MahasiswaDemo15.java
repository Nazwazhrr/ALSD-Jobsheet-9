import java.util.Scanner;
 public class MahasiswaDemo15 {
     public static void main(String[] args) {
         Scanner input15 = new Scanner(System.in);
         StackTugasMahasiswa15 stack = new StackTugasMahasiswa15(5);
         int pilih;
 
        do {
         System.out.println("\nMenu :");
         System.out.println("1. Mengumpulkan Tugas");
         System.out.println("2. Menilai Tugas");
         System.out.println("3. Melihat Tugas Teratas");
         System.out.println("4. Melihat Daftar Tugas");
         System.out.println("5. Lihat Tugas Pertama yang Masuk");
         System.out.println("6. Lihat Jumlah Tugas");
         System.out.print("Pilih: ");
         pilih = input15.nextInt();
         input15.nextLine();
         switch (pilih) {
             case 1 :
                 System.out.print("Nama: ");
                 String nama = input15.nextLine();
                 System.out.print("Nim : ");
                 String nim = input15.nextLine();
                 System.out.print("Kelas: ");
                 String kelas = input15.nextLine();
                 Mahasiswa15 mhs = new Mahasiswa15(nama, nim, kelas);
                 stack.push(mhs);
                 System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                 break;
             case 2:
             Mahasiswa15 dinilai = stack.pop();
             if (dinilai != null) {
                 System.out.println("Menilai tugas dari " + dinilai.nama);
                 System.out.print("Masukkan nilai (0-100): ");
                 int nilai = input15.nextInt();
                 dinilai.tugasDinilai(nilai);
                 System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
                 String biner = konversiDesimalKeBiner(nilai); 
                 System.out.println("Nilai Biner Tugas: " + biner); 
             }
             break;
         
             case 3:
                 Mahasiswa15 lihat = stack.peek();
                 if (lihat != null) {
                     System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);
                 }
                 break;
             case 4:
                 System.out.println("Daftar semua tugas");
                 System.out.println("Nama\tNIM\tKelas");
                 stack.print();
                 break;   
            case 5:
                Mahasiswa15 pertama = stack.bottom();
                if (pertama != null) {
                    System.out.println("Mahasiswa pertama yang mengumpulkan tugas:");
                    System.out.println(pertama.nama + "\t" + pertama.nim + "\t" + pertama.kelas);
                }
                break;
            case 6:
                System.out.println("Jumlah tugas sekarang: " + stack.hitungTugas());
                break;
             default:
                 System.out.println("Pilihan tidak valid.");
             }
         } while (pilih >= 1 && pilih <= 6);
      }

      public static String konversiDesimalKeBiner(int nilai) {
        StackKonversi15 stack = new StackKonversi15();
        while (nilai > 0) {
            int sisa = nilai % 2;
            stack.push(sisa);
            nilai = nilai / 2;
        }
    
        String biner = "";
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
    
        return biner;
    }
}