// Importing packages
import java.util.*;
// Defining class for methods.
class functions {

    // -------------Compound Interest Calculator-------------
    /*
    This method helps the user calculate Compound Interest in a given year 
    with a given interest rate for given years.
    It takes the principle, the final year of calculation and the interest percent as parameters.
    */

    static void Comp_Int(float principle, int calc_year, float interest) {
        System.out.println("Compound Interest Calculator: ");
        float ten_per;

        // while conditional for error handling
        if (calc_year <= 0) {
            System.out.println("Invalid year input\n");
        }
        else {        

            // Calculation code
            for (int i = 0; i < calc_year; i++) {
                ten_per = principle * interest/100; //Calculating 10 percent of current salary
                principle = principle + ten_per; // Adding 10 percent to salary.
            }

            // Display output
            System.out.println("The final amount will be: " + principle);
        }
    }

    // -----------Simple Interest Calculator------------
    /*
    This method helps the user calculate the Simple Interest for a given amount.
    It takes 
    */

    static void Simp_Int(int principle1, int time, int rate) {
        System.out.println("Simple Interest Calculator: ");
        int simple_int, amount;

        // Error handling using If conditional 
        if(time <= 0) {
            System.out.println("Invalid year input");
        }
        else {
            // Calculating Simple Interest.
            simple_int = (principle1 * rate * time) / 100;

            // Summing up the principle and the simple interest.
            amount = principle1 + simple_int;

            // Printing output
            System.out.println("The total amount after " + time + " years will be: " + amount);
        }
               
    }

    // ------------Day Finder------------
    /*
    This method helps the user to find the date of the week of the given date.
    It takes the total date as parameters. 
     */

    static String day_finder(int inp_date, int inp_mon, int inp_year) {
        System.out.println("Day Finder: ");
        int iter_date, iter_mon, iter_year;

        // Error handling
        if(inp_mon < 1 || inp_mon > 12) {
            System.out.println("Invalid Input");
        }

        // creating calendar object....... Important!!
		Calendar calendar = Calendar.getInstance();

        // current date and time data
        int curr_date = calendar.get(Calendar.DATE);        //current date
        // System.out.println(curr_date);

        int curr_mon = calendar.get(Calendar.MONTH) + 1;        //current month
		// System.out.println(curr_mon);

		int curr_year = calendar.get(Calendar.YEAR);        //current year
		// System.out.println(curr_year);

        // --------------Date Formatting----------------

        // Date formatting
        if (inp_date > curr_date) {
            iter_date = inp_date - curr_date;
        }
        else if (inp_date < curr_date) {
            iter_date = inp_date - curr_date;
        }
        else {
            iter_date = 0;
        }

        calendar.add(Calendar.DATE, iter_date); 
		// System.out.println(iter_date + " days change: " + calendar.getTime());

        // Month formatting
        if (inp_mon > curr_mon) {
            iter_mon = inp_mon - curr_mon;
        }
        else if (inp_mon < curr_mon) {
            iter_mon = inp_mon - curr_mon;
        }
        else {
            iter_mon = 0;
        }

        calendar.add(Calendar.MONTH, iter_mon); 
		// System.out.println(iter_mon + " months change: " + calendar.getTime());

        // Year formatting
        if (inp_year > curr_year) {
            iter_year = inp_year - curr_year;
        }
        else if (inp_year < curr_year) {
            iter_year = inp_year - curr_year;
        }
        else {
            iter_year = 0;
        }

        calendar.add(Calendar.YEAR, iter_year); 
        
        String datestring = calendar.getTime().toString().substring(0, 3);
        return datestring;
    }
    
    // ----------Calendar Maker-----------
    /*
    This method prints the calendar of the given month of the given year.
     */
    
    static void calendar_maker(int inp_mon1, int inp_year1) {
        System.out.println("Calendar Maker: ");

        // Error handling....
        if(inp_mon1 < 1 || inp_mon1 > 12) {
            System.out.println("Invalid Input");
        }

        // Declaring single and multi-dimensional arrays
        String days = ("SUN  MON  TUE  WED  THU  FRI  SAT");
        int[][] cal = new int[6][7];

        // Array iteration for days of months
        int[] day = {31, 2, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Iteration for days of february.
        if (inp_year1 % 4 == 0) {
            day[1] = 29;
        }
        else {
            day[1] = 28;
        }

        int max = day[inp_mon1 - 1];
        // System.out.println(max);

        // String hello = calendar.getTime().toString().substring(0, 3);
        String hello = day_finder(1, inp_mon1, inp_year1);

        String day_one = hello;
        System.out.println("First day of the month will be " + day_one + "\n");
        int a = 0;
        switch (day_one) {
            case "Sun":
                a = 0;
                break;

            case "Mon":
                a = 1;
                break;

            case "Tue":
                a = 2;
                break;

            case "Wed":
                a = 3;
                break;

            case "Thu":
                a = 4;
                break;

            case "Fri":
                a = 5;
                break;

            case "Sat":
                a = 6;
                break;
        
            default:
                break;
        }
        
        System.out.println(days);
        
        int c = 1;  //variable to iterate days of week
             
        // MAIN METHOD TO ITERATE THE DAYS OF A WEEK
        for (int rows = 0; rows <= 5; rows++) {     //rows iteration
            if (rows > 0) {     //setting column constant as default 
                a = 0;
            }
            for(int cols = a; cols <= 6; cols++) {    //columns iteration  
                
                cal[rows][cols] = c;
                if (c == max) {     //month limit test
                    break;
                }
                c++;
            }
        }
                 
        String spaces = "    ";
        // Printing Calendar using nested for loop.
        for (int rows = 0; rows <= 5; rows++) {
            for (int cols = 0; cols <= 6; cols++) {
                if (cal[rows][cols] >= 10) {
                    spaces = "   ";     //type 3 spaces for single digit numbers.
                }

                System.out.print(cal[rows][cols] + spaces);
            }
            System.out.println();
        }
    }

    public static void dash() {
        // Infinite loop for menu system
        boolean condi1 = true;

        while (condi1) {
            System.out.println("1. Calculate Compound Interest: ");
            System.out.println("2. Calculate Simple Interest: ");
            System.out.println("3. Day Finder: ");
            System.out.println("4. Calendar Maker: ");
            System.out.println("5. Exit dashboard\n");

            // Defining the Scanner object of its class
            Scanner sc = new Scanner(System.in);

            System.out.print("Choose your option: ");
            int inp = sc.nextInt();

            switch (inp) {
                case 1:
                    System.out.println("Enter the principle amount: ");
                    int prin = sc.nextInt();
                    System.out.println("Enter the year of interest calculation: ");
                    int time = sc.nextInt();
                    System.out.println("Enter the rate of interest: ");
                    int rate = sc.nextInt();
                    Comp_Int(prin, time, rate);
                    System.out.println("\n\n\n");
                    break;

                case 2:
                    System.out.println("Enter the principle amount: ");
                    int prin1 = sc.nextInt();
                    System.out.println("Enter the year of interest calculation: ");
                    int time1 = sc.nextInt();
                    System.out.println("Enter the rate of interest: ");
                    int rate1 = sc.nextInt();
                    Simp_Int(prin1, time1, rate1);
                    System.out.println("\n\n\n");
                    break;

                case 3:
                    System.out.println("Enter the day: ");
                    int day = sc.nextInt();
                    System.out.println("Enter the month: ");
                    int mon = sc.nextInt();
                    System.out.println("Enter the year: ");
                    int year = sc.nextInt();
                    System.out.println("The day will be " + day_finder(day, mon, year));
                    System.out.println("\n\n\n");
                    break;

                case 4:
                    System.out.println("Enter the month: ");
                    int mon1 = sc.nextInt();
                    System.out.println("Enter the year: ");
                    int year1 = sc.nextInt();
                    calendar_maker(mon1, year1);
                    System.out.println("\n\n\n");
                    break;

                case 5: 
                    condi1 = false;
                    main_db.main(null);
            
                default:
                    break;
            }
        }
    }

// Working class using inheritance.
public class teachers_dashboard extends functions {
    public static void main(String[] args) {
            dash();
        }
    }    
}