package entity;

import java.util.Date;

import database.PlayerDatabase;

public class BaseEntity extends PlayerDatabase {

    static private int id_counter = 1;

    private final int id;

    private Date createDate;

    public BaseEntity() {
        this.id = id_counter++;
        this.createDate = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

}
