public class Mahasiswa11 {
    // deklarasi atribut 
    String nim;
    String nama;
    String kelas;
    int nilai;

    // konstruktor
    Mahasiswa11(String nama, String nim, String kelas) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        nilai = -1; 
    }

    //method tugas dinilai
    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}