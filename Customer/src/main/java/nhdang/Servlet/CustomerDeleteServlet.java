package nhdang.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhdang.dao.CustomerDao;

@WebServlet("/customerDelete")
public class CustomerDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cusID = Integer.parseInt(request.getParameter("cusID"));

        try {
            CustomerDao.deleteCustomer(cusID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng lại trang danh sách khách hàng với thông báo lỗi
            request.setAttribute("errorString", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Sau khi xóa, chuyển hướng đến trang danh sách khách hàng
        response.sendRedirect(request.getContextPath() + "/customerList");
    }
}
