package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Validator;

/**
 *
 * @author Xiaomeng Li
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String first = request.getParameter("first");
        String second = request.getParameter("second");

        request.setAttribute("first", first.trim());
        request.setAttribute("second", second.trim());

        if (first == null || second == null || first.trim().equals("") || second.trim().equals("")) {
            request.setAttribute("result", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        String firstTrimmed = first.trim();
        String secondTrimmed = second.trim();
        
        // Handle Invalid input
        Validator validator = new Validator();
        if (! (validator.onlyNumber(firstTrimmed) && validator.onlyNumber(secondTrimmed))) {
            request.setAttribute("result", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        int firstNum = Integer.parseInt(firstTrimmed);
        int secondNum = Integer.parseInt(secondTrimmed);
//        System.out.println(request.getParameter("operator"));
        Character operator = request.getParameter("operator").charAt(0);
        int result = 0;
        switch(operator) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '%':
                result = firstNum % secondNum;
                break;
            default:
        }
        
        request.setAttribute("result", result + "");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }


}
