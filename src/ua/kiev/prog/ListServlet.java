package ua.kiev.prog;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        OutputStream out = resp.getOutputStream();
        MessageList ml = MessageList.getInstance();
        String login = req.getParameter("login");
        int room = Integer.parseInt(req.getParameter("room"));
        int i = Integer.parseInt(req.getParameter("from"));
        Message[] chat1 = ml.getArray(login, room, i);
        Gson gson1 = new GsonBuilder().create();
        String x = gson1.toJson(chat1);
        byte[] b = x.getBytes();
        out.write(b);
        out.close();
    }

}
