package pt.pa.adts;

public class PrintJob implements Comparable<PrintJob> {
    private String name;

    public enum Priority {LOW, NORMAL, HIGH}

    ;
    private Priority priority;
    private int numberOfPages;

    public PrintJob(String name, Priority priority, int numberOfPages) {
        this.name = name;
        this.priority = priority;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    /*
    public void setName(String name) { this.name = name; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }
    */
    @Override
    public int compareTo(PrintJob o) {
        //return this.priority.ordinal().compareTo(o.priority.ordinal());
        if (this.priority.ordinal() > o.priority.ordinal()) {
            return 1;
        } else if (this.priority.ordinal() < o.priority.ordinal()) {
            return -1;
        } else {
            return 0;
        }
    }
}
