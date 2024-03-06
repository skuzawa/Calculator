const operations = [];
const num = [];
var str = "";
var tmp = 0;
var cnt = 1;

/*
flag
0:直前に演算子を追加
1:直前に数字を追加
*/
var flag = [];
function get_calc(x) {
	if (x.value == "+" || x.value == "-" || x.value == "×" || x.value == "÷" || x.value == "=") {
		var hoge = flag[flag.length - 1];
		if (hoge == 1) {
			if (x.value != "=") {
				operations.push(x.value);
			}
			flag.push(0);
			num.push(tmp);
			tmp = 0;
			str += x.value;
		}

	} else if (x.value == "C") {
		str = str.slice(0, str.length - 1);
		var hoge = flag[flag.length - 1];
		if (hoge) {
			tmp = Number(tmp / 10);
		} else {
			operations.pop();
		}
		flag.pop();
	} else {
		tmp *= 10;
		tmp += Number(x.value);
		flag.push(1);
		str += x.value;
	}

	document.getElementById("operators").value = operations;
	document.getElementById("num").value = num;
	let text = document.getElementById("display");
	text.textContent = str;

	if (x.value == "=") {
		operations.splice(0);
		num.splice(0);


	}
}