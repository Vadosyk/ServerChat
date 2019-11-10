package ua.kiev.prog;

import java.util.HashSet;

public class User {

    public static HashSet<User> users = new HashSet<>();

    private String login;
    private String password;
    private boolean isOnline;
    private int room;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.isOnline = false;
        this.room = 0;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean getAccess(User u) {
        users.add(new User("user", "user"));
        users.add(new User("user2", "u1"));
        users.add(new User("user3", "1u"));
        users.add(new User("user4", "uu11"));
        users.add(new User("user5", "11uu"));
        User u1 = new User("user6", "1uu");
        u1.setRoom(1);
        users.add(u1);

        if (users.contains(u)) {
            for (User x : users) {
                if (x.equals(u))
                    x.isOnline = true;
                x.room = 0;
            }
        }

        return users.contains(u);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            return other.password == null;
        } else return password.equals(other.password);
    }

}
