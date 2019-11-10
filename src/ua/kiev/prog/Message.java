package ua.kiev.prog;

import java.util.Date;

public class Message {
    String from;
    String to;
    String text;
    Date date = new Date();
    boolean isPrivate;
    int room = 0;

    public Message() {
    }

    public Message(String from, String to, String text, Date date,
                   int room) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.date = date;
        this.room = room;
        if (to.equals("-"))
            this.isPrivate = false;
        else
            this.isPrivate = true;
    }

}
