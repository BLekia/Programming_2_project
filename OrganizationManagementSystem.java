import java.util.Scanner;

public class OrganizationManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        Group org = null;
        do {
            menu();
            input = sc.nextLine().trim().toLowerCase();

            switch (input) {
                case "1":
                    // Create and print hard coded organization
                    if (org == null) {
                        org = new Group("Top Managment", "John Worker");
                        Group marketing = new Group("Marketing", "Jack Styles");
                        Group hr = new Group("Human Resources", "Glenn Chambers");
                        Group sDev = new Group("Software Development", "Kermit Whodunnit");

                        org.add(new Worker("Hilda Hilda", "Secretary"));

                        marketing.add(new Worker("Blake Bad"));
                        marketing.add(new Worker("Jane Austin"));
                        marketing.add(new Worker("Hyde Jekyll"));
                        org.add(marketing);

                        hr.add(new Worker("Mandy Hopkins"));
                        hr.add(new Worker("May Day"));
                        hr.add(new Worker("Gary Riggby"));
                        org.add(hr);

                        sDev.add(new Worker("Sheldon Egg"));
                        sDev.add(new Worker("Jimmy Neutron"));
                        sDev.add(new Worker("Michael Lynx"));
                        org.add(sDev);
                    }

                    break;
                case "2":
                    // Print organization, add person to it and finally print it
                    if (org == null) {
                        System.out.println("\nOrganization not yet created. Create it in step 1.\n");

                    } else {
                        org.print();
                        System.out.println();

                        System.out.print("\nGive unit name: ");
                        input = sc.nextLine().trim();
                        Group result = org.findGroupByName(org, input);
                        if (result.groupName.equals(input)) {
                            try {
                                System.out.print("\nGive person name: ");
                                input = sc.nextLine().trim();
                                result.add(new Worker(input));
                            } catch (Exception e) {
                                System.out.println("Incorrect input.");
                            }
                        } else {
                            System.out.println("No matches found.");
                            return;
                        }

                    }
                    break;
                case "3":
                    // Print organization, remove person from it and finally print it
                    org.print();
                    System.out.println();

                    System.out.print("\nGive person name: ");
                    input = sc.nextLine().trim();

                    Group.removeWorkerByName(org, input);

                    break;
                case "q":
                    System.out.println("\nQuitting the application.\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
            org.print();
            System.out.println();
        }

        while (!input.equals("q"));

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