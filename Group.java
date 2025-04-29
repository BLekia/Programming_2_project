import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Group extends Organization {
    String name;
    String bossName;
    int index = 0;
    ArrayList<Organization> content = new ArrayList<Organization>();

    public Group(String name, String bossName) {
        this.name = name;
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
        System.out.println("Group: " + name + ", boss's name: " + bossName);
        {
            for (int i = 0; i < content.size(); i++)
                if (content.get(i) instanceof Group) {
                    fillerGroup = (Group) content.get(i);
                    fillerGroup.print();
                } else {
                    fillerWorker = (Worker) content.get(i);
                    fillerWorker.print();
                }

        }
    }

    public Group findGroupByName(Group currentGroup, String name) {
        if (currentGroup.name.equals(name)) {
            return currentGroup;
        }

        for (int i = 0; i < content.size(); i++) {
            if (content.get(i) instanceof Group) {
                Group foundGroup = findGroupByName((Group) content.get(i), name);
                if (foundGroup != null) {
                    return foundGroup;
                }
            }
        }

        return null;
    }

    public static void removeWorkerByName(Group currentGroup, String workerName) {
        List<Organization> elements = currentGroup.content;
        Iterator<Organization> iterator = elements.iterator();

        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element instanceof Worker) {
                Worker person = (Worker) element;
                if (person.name.equals(workerName)) {
                    iterator.remove();
                }
            } else if (element instanceof Group) {
                removeWorkerByName((Group) element, workerName);
            }
        }
    }
}
