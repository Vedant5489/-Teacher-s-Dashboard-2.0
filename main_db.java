import java.util.Scanner;

public class main_db extends operations{
    public static void main(String[] args){
        boolean condi = true;

        // Creating scanner class
        Scanner sc = new Scanner(System.in);

        // Creating object of functions class
        functions func = new functions();

        // Creating object of operations class
        operations op = new operations();
        
        // Taking input and initializing username and password
        // op.initiate();

        // Checking connection using try catch
        op.estab_connection();

        // Creating infinite while loop for menu system
        while (condi) {

            // Printing availiable options
            System.out.println("\n\n----------Welcome to The Teacher's Dashboard----------");
            System.out.println("1. Create record");
            System.out.println("2. Delete record");
            System.out.println("3. Show records");
            System.out.println("4. Update record");
            System.out.println("5. Open Dashboard");
            System.out.println("6. Exit");
            System.out.println("\nSelect your option...");

            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter URN: ");
                    String b = sc.next();
                    System.out.println("Enter Name: ");
                    String c = sc.next();
                    System.out.println("Enter Course: ");
                    String d = sc.next();
                    System.out.println("Enter Age");
                    int e = sc.nextInt();
                    System.out.println("Enter City");
                    String f = sc.next();
                    op.insert_data(b, c, d, e, f);

                    break;

                case 2:
                    System.out.println("Enter URN to delete record: ");
                    String a1 = sc.next();
                    op.del_data(a1);
                    break;

                case 3:
                    op.show_data();
                    break;

                case 4:
                    System.out.println("Enter URN to update: ");
                    String var3 = sc.next();
                    System.out.println("Enter column to update: ");
                    String var1 = sc.next();
                    System.out.println("Enter value of column: ");           
                    String var2 = sc.next();
                    
                    op.update(var1, var2, var3);
                    break;

                case 5: 
                    System.out.println("-----------Dashboard-----------");
                    func.dash();

                case 6: 
                    System.out.println("Vedant Patil\nvedant5489@gmail.com");
                    condi = false;
                    break;
            }
        }
        sc.close();
    }
}