public class Worker extends Organization {
    String name;
    int index = 1;
    String position = "";

    public Worker(String name) {
        this.name = name;

    }

    public Worker(String name, String position) {
        this.name = name;
        this.position = position;

    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.print("  ");
        }

        if (!position.equals("")) {
            System.out.println("Worker: " + name + "(" + position + ")");

        } else {
            System.out.println("Worker: " + name);
        }

    }

}
