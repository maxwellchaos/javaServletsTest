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
		//Перенаправление на страницу ввода логина
		request.getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Получаю данные со страницы
		String inputName = request.getParameter("user");
		String inputPass = request.getParameter("pass");
		
		//Устанавливаю атрибут имени - использую этот атрибут на страницах успешного входа
		request.setAttribute("name", inputName);

		//Если заполнить - то выведется страница с ошибкой
		String ErrorMessage = new String();
		
		//Принудительно задаю кодировку
		//Без этой строчки вызываемые страницы выводятся со знаками вопроса вместо русских букв
		response.setContentType("text/html; charset=UTF-8");
		
		//Правильные ли логины
		if(inputName.equals("student") || inputName.equals("guest"))
		{
		
			//----------Проверка на студента
			
			//equals вместо "==", поскольку "==" сравнивает ссылки и дает неверный ответ при сравнении строк
			if(inputName.equals("student"))
			{
				//проверяю пароль
				if(inputPass.equals("stud"))
				{
					request.getServletContext().getRequestDispatcher("/StudentPage.jsp").include(request, response);
				}
				else
				{
					ErrorMessage = "Пароль студена введен неправильно!";
				}
			}
	
			//----------Проверка на гостя
			
			if(inputName.equals("guest"))
			{
				if(inputPass.equals("guest"))
				{
					request.getServletContext().getRequestDispatcher("/GuestPage.jsp").include(request, response);
				}
				else
				{
					ErrorMessage = "Пароль гостя введен неправильно!";
				}
			}
		}
		else
		{
			ErrorMessage = "Неправильно введен логин!";
		}
		
		//----------Если ошибка
		if(!ErrorMessage.isEmpty())
		{
			request.setAttribute("ErrorMessage", ErrorMessage);
			request.getServletContext().getRequestDispatcher("/ErrorPage.jsp").include(request, response);
		}
		

	}

}
