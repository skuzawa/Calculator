<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>電卓</title>
<link rel="stylesheet" href="./styles/index.css">
<script src="/Calculator/js/calc.js"></script>
</head>
<body>
	<form action="top" method="POST">
		<div class=calcBox>
			<table>
				<!---液晶画面--->
				<tr>
					<p class="display" id="display">${ans}</p>
					</td>
				</tr>
				<!---上から１段目（7〜9+÷)--->
				<tr>
					<td><input type="button" value="7" onclick="get_calc(this)"></td>
					<td><input type="button" value="8" onclick="get_calc(this)"></td>
					<td><input type="button" value="9" onclick="get_calc(this)"></td>
					<td><input type="button" value="÷" class="operator"
						name="div_btn" onclick="get_calc(this)"></td>
				</tr>

				<!---上から２段目(4〜６+×)--->
				<tr>
					<td><input type="button" value="4" onclick="get_calc(this)"></td>
					<td><input type="button" value="5" onclick="get_calc(this)"></td>
					<td><input type="button" value="6" onclick="get_calc(this)"></td>
					<td><input type="button" value="×" class="operator"
						name="multi_btn" onclick="get_calc(this)"></td>
				</tr>

				<!---上から３段目(1〜3+-)--->
				<tr>
					<td><input type="button" value="1" onclick="get_calc(this)"></td>
					<td><input type="button" value="2" onclick="get_calc(this)"></td>
					<td><input type="button" value="3" onclick="get_calc(this)"></td>
					<td><input type="button" value="-" class="operator"
						onclick="get_calc(this)"></td>
				</tr>

				<!---上から4段目(0/C/=/+)--->
				<tr>
					<td><input type="button" value="0" onclick="get_calc(this)"></td>
					<td><input type="button" value="C" onclick="get_calc(this)"></td>
					<td><button type="submit" value="=" class="equal"
							onclick="get_calc(this)">=</td>
					<td><input type="button" value="+" class="operator"
						onclick="get_calc(this)"></td>
				</tr>
				<input type="hidden" name="operators" id="operators" value="">
				<input type="hidden" name="num" id="num" value="">
			</table>
		</div>

	</form>
	<div class="historyBox">
		<button id="hisBtn" onclick="his()">履歴</button>
		<div class="history">
			<p>${case0}</p>
			<p>${case1}</p>
			<p>${case2}</p>
		</div>
		
	</div>
</body>
</html>