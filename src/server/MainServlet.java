package server;

import logic.FunctionCalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns = {"/simple"})
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            double h = Double.parseDouble(request.getParameter("h"));
            FunctionCalculator functionCalculator = new FunctionCalculator(a,b,h, request.getParameter("f"));
            request.setAttribute("calc", functionCalculator);
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        } catch (NumberFormatException nfe) {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        try {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<h2>");
            printWriter.printf("Hello, %s! ", name);
            printWriter.println("</h2>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
