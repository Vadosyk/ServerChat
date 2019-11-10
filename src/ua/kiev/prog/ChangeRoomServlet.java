package ua.kiev.prog;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String login = req.getParameter("login");
        int room = Integer.parseInt(req.getParameter("room"));
        boolean flag = false;
        for (User u : User.users) {
            if (u.getLogin().equals(login)) {
                u.setRoom(room);
                flag = true;
            }
        }

        if (flag == true) {
            resp.setStatus(200);
        } else
            resp.setStatus(400);
    }

}
