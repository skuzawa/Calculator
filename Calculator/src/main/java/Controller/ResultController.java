package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultController
 */
@WebServlet("/result")
public class ResultController extends HttpServlet {

	public int calc(String operators, String num) {
		String ope[] = operators.split(",");
		String math[] = num.split(",");
		int ans = Integer.parseInt(math[0]);
		int len = ope.length;

		for (int i = 1; i <= len; i++) {
			switch (ope[i - 1]) {
			case "+":
				ans += Integer.parseInt(math[i]);
				break;
			case "-":
				ans -= Integer.parseInt(math[i]);
				break;
			case "×":
				ans *= Integer.parseInt(math[i]);
				break;
			case "÷":
				int tmp = Integer.parseInt(math[i]);
				if (tmp == 0) {
					;
				} else {
					ans /= Integer.parseInt(math[i]);
					break;
				}
			}
		}
		return ans;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String operators = request.getParameter("operators");
		String num = request.getParameter("num");

		System.out.println(operators);
		System.out.println(num);

		int ans = calc(operators, num);
		request.setAttribute("ans", ans);

		// 発行した受付番号ををリクエスト属性として設定
		//request.setAttribute("", );

		// thanks.jsp にリダイレクト
		String view = "/WEB-INF/views/result.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//			throws ServletException, IOException {
	//
	//		
	//	}

}
