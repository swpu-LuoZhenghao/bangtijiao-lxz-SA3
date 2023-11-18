package b_s.Server;

import b_s.Entity.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/listServlet")
public class List extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        java.util.List<People> pb = null;
        try {
            pb = JDBC.query();
            req.setAttribute("pb",pb);
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
