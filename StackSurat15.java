public class StackSurat15 {
    Surat15[] stack;
    int size;
    int top;

    public StackSurat15(int size) {
        this.size = size;
        stack = new Surat15[size];
        top = -1;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Surat15 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan surat lagi.");
        }
    }

    public Surat15 pop() {
        if (!isEmpty()) {
            Surat15 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diambil.");
            return null;
        }
    }

    public Surat15 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat yang tersedia.");
            return null;
        }
    }

    public void print() {
        if (top == -1) {
            System.out.println("Stack kosong! Tidak ada surat yang tersedia.");
        } else {
            System.out.println("Daftar surat dalam stack:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i].toString());  
            }
        }
    }   
}
