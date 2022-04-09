import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@WebServlet(name = "FirstServlet", urlPatterns = "/firstApp")
public class FirstServlet extends HttpServlet {
    private final String[] titles = {"Апельсины", "Яблоки", "Груши", "Мандарины", "Бананы",
            "Манго", "Личи", "Абрикос", "Персик", "Помело"}; // набор названий продуктов
    private Product[] products;
    private final static String ENCODING_UTF_8 = "UTF-8";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(ENCODING_UTF_8);
        resp.setContentType("text/html; charset=UTF-8"); //после этого не переводит на новую строку но отображает Русский
        resp.setCharacterEncoding(ENCODING_UTF_8);
         products = new Product[10];
        double scale = Math.pow(10, 2);//округление до 2х знаков
        for (int i =0;i<products.length;i++) {
            products[i]=new Product(i+1,
                    titles[(int)Math.round(Math.random()*(titles.length-1))],
                    Math.round(Math.random()*100 * scale)/scale);
        }
        resp.getWriter().println("Продукты:");
        resp.getWriter().println(Arrays.toString(products));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
