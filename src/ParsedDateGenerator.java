import java.util.Scanner;
public class ParsedDateGenerator {
    public static void parsedDate() {
        Scanner sc = new Scanner(System.in);
        int day = 0, month = 0, year = 0;
        boolean done = false;

        while(!done) {
            try {
                System.out.println("Enter date to parse (MM/DD/YYYY format): ");
                String userInput = sc.nextLine();
                String[] correctDate = userInput.split("/");
                month = Integer.parseInt(correctDate[0]);
                day = Integer.parseInt(correctDate[1]);
                year = Integer.parseInt(correctDate[2]);

                if (month < 1 || month > 12) {
                    throw new MonthException("Invalid Month. Reenter a valid month: ");
                }if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 9 || month == 12) && day > 31)
                        throw new DayException("Invalid day. Reenter a valid day: ");
                if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                        throw new DayException("Invalid day. Reenter a valid day: ");
                }if(month == 2 && day > 28){
                        throw new DayException("Invalid day. Reenter a valid day: ");
                } else if (year < 1000 || year > 3000) {
                    throw new YearException("Invalid year. Reenter a valid year: ");
                }
                System.out.println("Parsed date: " + SwitchCase.switchCase(month) + " " + day + ", " + year);
                break;


            } // end try
            catch (MonthException me) {
                System.out.println(me.getMessage());
                month = Integer.parseInt(sc.nextLine());
                System.out.println("Parsed date: " + SwitchCase.switchCase(month) + " " + day + ", " + year + "\n");
                break;

            } catch (DayException de) {
                System.out.println(de.getMessage());
                day = Integer.parseInt(sc.nextLine());
                System.out.println("Parsed date: " + SwitchCase.switchCase(month) + " " + day + ", " + year + "\n");
                break;

            } catch (YearException ye) {
                System.out.println(ye.getMessage());
                year = Integer.parseInt(sc.nextLine());
                System.out.println("Parsed date: " + SwitchCase.switchCase(month) + " " + day + ", " + year + "\n");
                break;

            }
        }//end while
    }//end method
}//end class
