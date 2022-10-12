/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.UserDao;
import evoting.dao.VoterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Shrasti
 */
@WebServlet(name = "ManageUserControllerServlet", urlPatterns = {"/ManageUserControllerServlet"})
public class ManageUserControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HashMap<String, Integer> mfm = UserDao.getMaleAndFemale();
            HashMap<String, Integer> mfmVote = VoterDAO.getMaleFemaleVote();
            System.out.println("MFM "+mfm);
            System.out.println("MFM Vote "+mfmVote);
            JSONObject arrobj = new JSONObject();
            arrobj.put("result", "<div id=\"chartContainer\" style=\"height: 300px; width: 100%;\"></div>");
            {
                JSONArray mfmarrobj = new JSONArray();
                {
                    JSONObject mfmobj = new JSONObject();
                    mfmobj.put("y", mfm.get("M"));
                    mfmobj.put("label", "Male");
                    mfmarrobj.put(mfmobj);

                    mfmobj = new JSONObject();
                    mfmobj.put("y", mfm.get("F"));
                    mfmobj.put("label", "Female");
                    mfmarrobj.put(mfmobj);

                }
                arrobj.put("MaleFemale", mfmarrobj);

                mfmarrobj = new JSONArray();
                {
                    JSONObject mfmobj = new JSONObject();
                    mfmobj.put("y", mfmVote.get("M"));
                    mfmobj.put("label", "Male");
                    mfmarrobj.put(mfmobj);

                    mfmobj = new JSONObject();
                    mfmobj.put("y", mfmVote.get("F"));
                    mfmobj.put("label", "Female");
                    mfmarrobj.put(mfmobj);

                }
                arrobj.put("MaleFemaleVote", mfmarrobj);

            }
            out.print(arrobj);

        } catch (Exception ex) {
            ex.printStackTrace();
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("showexception.jsp");
            request.setAttribute("Exception", ex);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
