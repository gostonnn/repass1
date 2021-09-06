import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        namemark();
        //Fejrész kiírása
        System.out.println("Jelszavak");
        //Verzió kiírása
        System.out.println("Verzió: 0.0.1");
        
        //Az a objektummal kérhetünk be a konzolról
        Scanner scanner = new Scanner(System.in);

        System.out.print("Felhasználónév: ");
        // A b változó tárolja a jelszót
        String name = scanner.nextLine();
        System.out.print("Jelszó: ");
        String password = scanner.nextLine();
        System.out.print("Hely: ");
        String city = scanner.nextLine();
        scanner.close();
        int success = 0;
        try {
            /* 
            A jelszó, a felhasználónév és a 
            használati helye a passList 
            objektumban van tárolva            
            */
            Store passStore = new Store(name, password, city);
            FileWriter file = new FileWriter("pass.txt");
            PrintWriter pwr = new PrintWriter(file);
            pwr.print(passStore.user);
            if(!passStore.hollow()) { pwr.print(passStore.retrieval()); }
            pwr.print(passStore.place);
            pwr.close();
            success = 1;
        } catch (IOException e) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }

        if(success == 1) { System.out.println("Ok. A kiírás sikeres.");  }else {  System.out.println("Hiba! A kiírás sikertelen"); }

    }

    public static void namemark() {
        System.out.println("Nagy János");
    }
}
