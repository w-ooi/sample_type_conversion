<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date,java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データ型の変換</title>
<%
	String stringDate = (String)request.getAttribute("stringDate");
	java.sql.Date sqlDate = (java.sql.Date)request.getAttribute("sqlDate");
	String convertString = (String)request.getAttribute("convertString");
	Calendar calendarDate = (Calendar)request.getAttribute("calendarDate");
	String compResult1 = (String)request.getAttribute("compResult1");
	Calendar nowDate = (Calendar)request.getAttribute("nowDate");
	String compResult2 = (String)request.getAttribute("compResult2");
	
	// Calendarの値を加工
	int cYear = calendarDate.get(Calendar.YEAR);			// 年
	int cMonth = calendarDate.get(Calendar.MONTH) + 1;	// 月(0~11で返るので1加算する仕様)
	int cDate = calendarDate.get(Calendar.DATE);			// 日
	int cHour = calendarDate.get(Calendar.HOUR_OF_DAY);	// 時間
	String strCalendar = cYear + "年" + cMonth + "月" + cDate + "日" + cHour + "時";
	
	int nYear = nowDate.get(Calendar.YEAR);			// 年
	int nMonth = nowDate.get(Calendar.MONTH) + 1;	// 月(0~11で返るので1加算する仕様)
	int nDate = nowDate.get(Calendar.DATE);			// 日
	int nHour = nowDate.get(Calendar.HOUR_OF_DAY);	// 時間
	String strNow = nYear + "年" + nMonth + "月" + nDate + "日" + nHour + "時";


	
	
%>
</head>
<body>
<h2>変換結果</h2>
<table border="1">
<tr><th>カレンダーの値</th><td><%= stringDate %></td></tr>
<tr><th>java.sql.Date型へ</th><td><%= sqlDate %></td></tr>
<tr><th>再度String型へ</th><td><%= convertString %></td></tr>
<tr><th>Calendar型へ</th><td><%= strCalendar %></td></tr>
<tr><th>日時の比較</th><td><%= compResult1 %></td></tr>
<tr><th>現在日時</th><td><%= strNow %></td></tr>
<tr><th>日時の比較</th><td><%= compResult2 %></td></tr>
</table>
</body>
</html>