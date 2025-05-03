import java.util.Scanner;
public class DemoSurat15 {
    public static void main(String[] args) {
        Scanner input15 = new Scanner(System.in);
        StackSurat15 stackSurat = new StackSurat15(5); 

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = input15.nextInt(); input15.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat: ");
                    String idSurat = input15.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String namaMahasiswa = input15.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = input15.nextLine();
                    System.out.print("Jenis Izin (I untuk Izin, S untuk Sakit): ");
                    char jenisIzin = input15.next().toUpperCase().charAt(0);
                    System.out.print("Durasi (dalam hari): ");
                    int durasi = input15.nextInt(); input15.nextLine();
                    Surat15 surat = new Surat15(idSurat, namaMahasiswa, kelas, jenisIzin, durasi);
                    stackSurat.push(surat);
                    System.out.println("\nData surat berhasil dimasukkan.");
                    break;

                case 2:
                    Surat15 suratKeluar = stackSurat.pop();
                    if (suratKeluar != null) {
                        System.out.println("\n--- Surat Diproses ---");
                        System.out.println("Nama Mahasiswa : " + suratKeluar.namaMahasiswa);
                        System.out.println("ID Surat       : " + suratKeluar.idSurat);
                        System.out.println("Jenis Izin     : " + 
                            (suratKeluar.jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain"));
                        System.out.println("Status         : Selesai diverifikasi!");
                    } else {
                        System.out.println("\nTidak ada surat yang bisa diproses.");
                    }
                    break;

                case 3:
                    Surat15 palingAtas = stackSurat.peek();
                    if (palingAtas != null) {
                        System.out.println("\n--- Surat Paling Baru ---");
                        palingAtas.print();
                    } else {
                        System.out.println("\nBelum ada surat masuk di stack.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa yang ingin dicari: ");
                    String namaCari = input15.nextLine();
                    boolean ada = false;
                    System.out.println("\nHasil pencarian:");
                    for (int i = stackSurat.top; i >= 0; i--) {
                        if (stackSurat.stack[i].namaMahasiswa.equalsIgnoreCase(namaCari)) {
                            stackSurat.stack[i].print();  
                            ada = true;
                        }
                    }
                    if (!ada) {
                        System.out.println("Tidak ditemukan surat atas nama " + namaCari);
                    }
                    break;

                case 0:
                    System.out.println("\nTerima kasih telah menggunakan program.");
                    return;

                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        }
    }
}