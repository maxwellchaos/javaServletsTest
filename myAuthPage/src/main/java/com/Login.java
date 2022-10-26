package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������������� �� �������� ����� ������
		request.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������� ������ �� ��������
		String inputName = request.getParameter("user");
		String inputPass = request.getParameter("pass");
		
		//������������ ������� ����� - ��������� ���� ������� �� ��������� ��������� �����
		request.setAttribute("name", inputName);

		//���� ��������� - �� ��������� �������� � �������
		String ErrorMessage = new String();
		
		//������������� ����� ���������
		//��� ���� ������� ���������� �������� ��������� �� ������� ������� ������ ������� ����
		response.setContentType("text/html; charset=UTF-8");
		
		//���������� �� ������
		if(inputName.equals("student") || inputName.equals("guest"))
		{
		
			//----------�������� �� ��������
			
			//equals ������ "==", ��������� "==" ���������� ������ � ���� �������� ����� ��� ��������� �����
			if(inputName.equals("student"))
			{
				//�������� ������
				if(inputPass.equals("stud"))
				{
					request.getServletContext().getRequestDispatcher("/StudentPage.jsp").include(request, response);
				}
				else
				{
					ErrorMessage = "������ ������� ������ �����������!";
				}
			}
	
			//----------�������� �� �����
			
			if(inputName.equals("guest"))
			{
				if(inputPass.equals("guest"))
				{
					request.getServletContext().getRequestDispatcher("/GuestPage.jsp").include(request, response);
				}
				else
				{
					ErrorMessage = "������ ����� ������ �����������!";
				}
			}
		}
		else
		{
			ErrorMessage = "����������� ������ �����!";
		}
		
		//----------���� ������
		if(!ErrorMessage.isEmpty())
		{
			request.setAttribute("ErrorMessage", ErrorMessage);
			request.getServletContext().getRequestDispatcher("/ErrorPage.jsp").include(request, response);
		}
		

	}

}
