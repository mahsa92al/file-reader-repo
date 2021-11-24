package ir.maktab.model;

import java.sql.Timestamp;

/**
 * @author Mahsa Alikhani m-58
 */
public class Course {
    private String name;
    private Timestamp timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
