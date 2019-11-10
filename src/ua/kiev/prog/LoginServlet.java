package ua.kiev.prog;

import java.io.IOException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User u = new User(login, password);
        if (User.getAccess(u))
            resp.setStatus(200);
        else
            resp.setStatus(400);
    }

}
