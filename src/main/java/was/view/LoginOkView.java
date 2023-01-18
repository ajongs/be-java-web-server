package was.view;

import db.SessionStorage;
import model.User;
import webserver.domain.HttpRequest;
import webserver.session.Session;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class LoginOkView {
    static public byte[] makePage(UUID sid) {
        StringBuilder sb = new StringBuilder();
        try {
            Session session = SessionStorage.findSessionBy(sid);
            BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/templates/index.html"));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);

                if (str.contains("<ul class=\"nav navbar-nav navbar-right\">")) {
                    sb.append("<li><a href=\"#\">");
                    sb.append(session.getUserId() + "님");
                    sb.append("</a></li>");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString().getBytes();
    }
}
