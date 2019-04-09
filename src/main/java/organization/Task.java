package organization;

import java.util.Date;

public class Task {
    private String text;
    private long date;
    private long dueDate;

//    public Task(String text, long date, long dueDate) {
//        this.text = text;
//        this.date = date;
//        this.dueDate = dueDate;
//    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }
}
