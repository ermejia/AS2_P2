package gt.com.umg.AS2P2.servlet;

import gt.com.umg.AS2P2.controller.AnimalController;
import gt.com.umg.AS2P2.dao.AnimalDao;
import gt.com.umg.AS2P2.entity.AnimalEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudServlet")
public class CrudServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnimalEntity animal = new AnimalEntity();
        AnimalDao dao = new AnimalDao();
        String idArea = request.getParameter("idArea");
        String idAnimal = request.getParameter("idAnimal");
        String age = request.getParameter("age");
        request.getSession(true).setAttribute("idArea",idArea);
        if (idAnimal.equals("")){
            animal.setIdAnimal(0);
        }else{
            animal.setIdAnimal(Integer.parseInt(idAnimal));
        }
        animal.setIdArea(Integer.parseInt(request.getParameter("idArea")));
        animal.setName(request.getParameter("name"));
        animal.setWeight(Float.parseFloat(request.getParameter("weight")));
        animal.setHeigth(Float.parseFloat(request.getParameter("heigth")));
        animal.setGender(request.getParameter("gender"));
        animal.setAge(Integer.parseInt(age));
        animal.setColor(request.getParameter("color"));
        animal.setCountry(request.getParameter("country"));
        animal.setExtinctionRisk(request.getParameter("extinction"));
        animal.setSciName(request.getParameter("sciname"));

        if("create".equals(request.getParameter("btn_create"))){
            if(dao.create(animal)>0){
                response.sendRedirect("/AS2P2-1.0-SNAPSHOT/table.html");
            }
        }
        if("update".equals(request.getParameter("btn_update"))){
            if(dao.update(animal)>0){
                response.sendRedirect("/AS2P2-1.0-SNAPSHOT/table.html");
            }
        }
        if("delete".equals(request.getParameter("btn_delete"))){
            if(dao.delete(request.getParameter("idAnimal"))>0){
                response.sendRedirect("/AS2P2-1.0-SNAPSHOT/table.html");
            }
        }

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
