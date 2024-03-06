package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/top")
public class CalcController extends HttpServlet {
	//呼び出された回数
	int cnt = 0;
	
	public int calc(String operators, String num, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String ope[] = operators.split(",");
		String math[] = num.split(",");
		String ans_str = "";
		
		int ans = Integer.parseInt(math[0]);
		int len = ope.length;
		int math_len = math.length;
		if(len+1 != math_len) {
			return -10000000;
		}
		ans_str += math[0];
		for (int i = 1; i <= len; i++) {
			switch (ope[i - 1]) {
			case "+":
				ans += Integer.parseInt(math[i]);
				ans_str += ope[i-1];
				ans_str += math[i];
				break;
			case "-":
				ans -= Integer.parseInt(math[i]);
				ans_str += ope[i-1];
				ans_str += math[i];
				break;
			case "×":
				ans *= Integer.parseInt(math[i]);
				ans_str += ope[i-1];
				ans_str += math[i];
				break;
			case "÷":
				int tmp = Integer.parseInt(math[i]);
				if (tmp == 0) {
					session.setAttribute("case1","定義できません");
					return 10000000;
				} else {
					ans /= Integer.parseInt(math[i]);
					ans_str += ope[i-1];
					ans_str += math[i];
					break;
				}
			}
		}
		ans_str += ("=" + ans);
		String s = "case" + (cnt % 3);
		session.setAttribute(s, ans_str);
		cnt++;
		return ans;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/views/calc.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		

		String operators = request.getParameter("operators");
		String num = request.getParameter("num");
		
		int ans = calc(operators, num, request);
		if(ans == 10000000) {
			request.setAttribute("ans", "定義できません");
		}else if(ans == -10000000){
			request.setAttribute("ans", "計算できません");
		}else {
			request.setAttribute("ans", ans);
		}
		
		doGet(request, response);
	}
}