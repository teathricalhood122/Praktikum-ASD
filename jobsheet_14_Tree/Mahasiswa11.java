package jobsheet_14_Tree;

public class Mahasiswa11 { //deklarasi class utama
    String nim;
    String nama;
    String kelas;
    double ipk;


    public Mahasiswa11() {
    }

    public Mahasiswa11(String nim, String nama, String kelas, double ipk ){
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi(){ // method tampil informasi 
        System.out.println("NIM: "+this.nim+" " +
        "Nama: "+ this.nama+" " +
        "Kelas: "+ this.kelas+" "+
        "IPK: "+ this.ipk+" " );
    }

}