package gt.com.umg.AS2P2.servlet;

import gt.com.umg.AS2P2.controller.AnimalController;
import gt.com.umg.AS2P2.dao.AnimalDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/animalServlet")
public class AnimalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idArea = request.getParameter("idArea");
        request.getSession(true).setAttribute("idArea",idArea);
        System.out.println(request.getSession(false).getAttribute("idArea"));
        response.sendRedirect("/AS2P2-1.0-SNAPSHOT/table.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnimalController getAnimal = new AnimalController();
        List<String> tabla = new LinkedList<>();
        String idArea = (String) request.getSession(false).getAttribute("idArea");
        tabla = getAnimal.convertAllAnimal(idArea);

        try (PrintWriter out = response.getWriter()){
            out.println(tabla);
            System.out.println(request.getSession(false).getAttribute("idArea"));
        }
    }
}
