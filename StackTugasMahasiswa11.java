public class StackTugasMahasiswa11 {
    //calss stacktugas mahasiswa
    Mahasiswa11[] stack;
    int top;
    int size;


public StackTugasMahasiswa11(int size){
    // konstruktor berparameter top
    this.size = size;
    stack = new Mahasiswa11[size];
    top = -1;
}

public boolean isFull(){ //method isfull
    if (top == size -1){
        return true;
    } else {
        return false;
    }
}

public boolean isEmpty(){ //method isempty
    if (top == -1) {
        return true;
    } else{
        return false;
    }
}

public void push(Mahasiswa11 mhs){ //method untuk menerima paramaeter mhs
    if (!isFull()) {
        top++;
        stack[top] = mhs;
    } else{
        System.out.println("Stack Penuh! Tidak bisa menambahkan tugas lagi.");
    }
}

public Mahasiswa11 pop(){
    if (!isEmpty()) {
        Mahasiswa11 m= stack[top];
        top--;
        return m;
    } else{
        System.out.println("Stack kosong! Tidak ada tugas untuk dninilai");
        return null;
    } 
}

public Mahasiswa11 peek(){
    if (!isEmpty()) {
        return stack[top];
    } else {
        System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
        return null;
    }
}

public void print(){
    for (int i = 0; i < top; i--) {
        System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
    }
    System.out.println("");
}

public Mahasiswa11 peekTerbawah() { // tugas no 4
    if (!isEmpty()) {
        return stack[0]; //ambil index awal paling bawah 
    } else {
        System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
        return null;
    }
}
public int hitungTugas() {
    return top + 1; 
}
}