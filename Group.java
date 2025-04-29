import java.util.ArrayList;

public class Group extends Organization {
    String groupName;
    String bossName;
    int index = 0;
    ArrayList<Object> content = new ArrayList<Object>();

    public Group(String groupName, String bossName) {
        this.groupName = groupName;
        this.bossName = bossName;
    }

    public void add(Object toBeAdded) {
        if (toBeAdded instanceof Group) {
            Group cast = (Group) toBeAdded;
            cast.index++;
            content.add(cast);
        } else {
            Worker cast = (Worker) toBeAdded;
            cast.index++;
            content.add(cast);
        }

    }

    public void remove() {

    }

    public void print() {
        Group fillerGroup;
        Worker fillerWorker;
        System.out.println();
        for (int i = 0; i < index; i++) {
            System.out.print("  ");
        }
        System.out.println("Group: " + groupName + ", boss's name: " + bossName);
        for (int i = 0; i < content.size(); i++) {

            if (content.get(i) instanceof Group) {
                fillerGroup = (Group) content.get(i);
                fillerGroup.print();
            } else {
                fillerWorker = (Worker) content.get(i);
                fillerWorker.print();
            }

        }
    }
}
