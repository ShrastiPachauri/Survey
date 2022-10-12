/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.CandidateDAO;
import evoting.dto.CandidateDTO;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Shrasti
 */
public class AddNewCandidateControllerServlet extends HttpServlet {

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
        RequestDispatcher rd=null;
        InputStream inp=null;
        List<String> objValues=new ArrayList<String>();
        
        try{
            DiskFileItemFactory df=new DiskFileItemFactory();        //understand theses lines well ,to store images coming from addCndidate()
            ServletFileUpload sfu=new ServletFileUpload(df);
            ServletRequestContext srq=new ServletRequestContext(request);//this from ajax requset has data
            List<FileItem>multilist=sfu.parseRequest(srq);
            for(FileItem fit:multilist)
            {
                if(fit.isFormField())
                {
                    String value=fit.getString();
                    String fname=fit.getFieldName();
                    System.out.println("value and fname are "+value+" "+fname);
                    objValues.add(value);
                }
                else
                {
                    inp=fit.getInputStream();
                    String key=fit.getFieldName();
                    String filename=fit.getName();
                    System.out.println("key and filename are "+key+" "+filename);
                }
            }
          CandidateDTO candidate=new CandidateDTO(objValues.get(0),objValues.get(3),objValues.get(4),objValues.get(1),inp,objValues.get(2)); //b/c we will get data from form in same oredr alsways
         boolean result=CandidateDAO.addCandidate(candidate);
           if(result==true)
           {
                System.out.println("inserted successfully");
                rd=request.getRequestDispatcher("success.jsp");
            }
            else
            {
                 System.out.println("not inserted");
                rd=request.getRequestDispatcher("failure.jsp");
            }
            
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception in AddNewCandidateController");
            ex.printStackTrace();
        }
        finally
        {
            if(rd!=null)
            {
                rd.forward(request, response);
            }
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
