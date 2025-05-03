public class Mahasiswa15 {
    String nama;
    String nim;
    String kelas;
    int nilai;

    public Mahasiswa15() {
    }

    Mahasiswa15(String nama, String nim, String kelas) {
        this.nama = nama;
        this.nim  = nim;
        this.kelas = kelas;
        this.nilai = -1;
    }

    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }

    public void tampil() {
        System.out.println("Nama : " +  nama);
        System.out.println("NIM : " + nim);
        System.out.println("Kelas : " + kelas);
        System.out.println("Nilai : " + nilai);
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
