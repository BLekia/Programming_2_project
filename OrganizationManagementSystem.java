import java.util.Scanner;

public class OrganizationManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        do {
            menu();
            input = sc.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "q":
                    System.out.println("\nQuitting the application.\n");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        } while (!input.equals("q"));

        sc.close();
    }

    private static void menu() {
        System.out.println("Organization management system\n");
        System.out.println("------------------------------");
        System.out.println("1. Create and print hard coded organization");
        System.out.println("2. Print organization, add person to it and finally print it");
        System.out.println("3. Print organization, remove person from it and finally print it");
        System.out.println("Q. Quit the application");
        System.out.print("\nYour choice: ");
    }

}