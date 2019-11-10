package ua.kiev.prog;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        InputStream in = req.getInputStream();
        byte[] b = new byte[in.available()];
        StringBuilder sb = new StringBuilder();
        in.read(b);
        for (byte bb : b) {

            char c = (char) bb;
            sb.append(c);
        }
        String x = sb.toString();

        Gson gson2 = new GsonBuilder().create();
        Message m = (Message) gson2.fromJson(x, Message.class);
        MessageList ml = MessageList.getInstance();
        ml.add(m);

        if (!m.equals(null))
            resp.setStatus(200);
        else
            resp.setStatus(404);

        in.close();

    }
}
