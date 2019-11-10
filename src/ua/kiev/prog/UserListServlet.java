package ua.kiev.prog;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int room = Integer.parseInt(req.getParameter("room"));
        OutputStream out = resp.getOutputStream();
        HashMap<String, String> hm = new HashMap<>();
        String onl;
        for (User u : User.users) {
            if (room == u.getRoom()) {
                onl = (u.isOnline()) ? "online" : "ofline";
                hm.put(u.getLogin(), onl);
            }
        }

        Gson gson1 = new GsonBuilder().create();
        String x = gson1.toJson(hm);
        byte[] b = x.getBytes();
        out.write(b);
        out.close();

    }
}
