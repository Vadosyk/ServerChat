package ua.kiev.prog;

import java.util.ArrayList;

public class MessageList {
    private static final MessageList msgList = new MessageList();
    private final ArrayList<Message> list = new ArrayList<Message>();

    public static MessageList getInstance() {
        return msgList;
    }

    public synchronized void add(Message m) {
        list.add(m);
    }

    public synchronized Message[] getArray(String login, int room, int i) {
        ArrayList<Message> chatList = new ArrayList<Message>();
        Message[] mes = list.toArray(new Message[list.size()]);

        for (int j=i; j<mes.length; j++) {
            if (mes[j].to.equals(login) && (mes[j].isPrivate == true)) {
                chatList.add(mes[j]);
            } else if ((mes[j].room == room) && (mes[j].isPrivate == false)) {
                chatList.add(mes[j]);
            }
        }

        Message[] result = chatList.toArray(new Message[chatList.size()]);
        return result;
    }

}
