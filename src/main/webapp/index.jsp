<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データ型の変換</title>
</head>
<body>
<h2>データ型の変換</h2>
<p>
カレンダーの日付は「yyyy-MM-dd」形式の「String型」として扱われるが、<br>
MySQLのテーブルに挿入する場合には「java.sql.Date型」に変換する必要がある。<br><br>
また日時の比較を行う場合は「Calendar型」に変換するが、その際には<br>
「String型」→「java.util.Date型」→「Calendar型」に変換する必要がある。<br><br>
特に「java.sql.Date型」と「java.util.Date型」は別物なので注意すること。
</p>
<hr>
<h2>変換サンプル</h2>
<form action="typefc" method="post">
<input type="date" name="stringDate" required>&nbsp;<input type="submit" value="送信">
<input type="hidden" name="visit" value="typeConvert">
</form>
</body>
</html>