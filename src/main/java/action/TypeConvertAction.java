package action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TypeConvert;

public class TypeConvertAction implements IAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// カレンダーの値を取得
		String stringDate = request.getParameter("stringDate");
		
		// データ型変換サンプルのクラス
		TypeConvert tc = new TypeConvert();
		
		// String → java.sql.Dateへ変換
		java.sql.Date sqlDate = tc.stringToSQLDate(stringDate);
		
		// java.sql.Date → Stringへ変換
		String convertString = tc.sqlDateToString(sqlDate);
		
		// String → Calendarへ変換し、14時以降か比較
		Calendar calendarDate = tc.stringToCalendar(stringDate);
		String compResult1 = tc.compareCalendar(calendarDate);
		
		// 現在日時を取得し、14時以降か比較
		Calendar nowDate = Calendar.getInstance();
		String compResult2 = tc.compareCalendar(nowDate);
		
		// 結果を格納
		request.setAttribute("stringDate", stringDate);
		request.setAttribute("sqlDate", sqlDate);
		request.setAttribute("convertString", convertString);
		request.setAttribute("calendarDate", calendarDate);
		request.setAttribute("compResult1", compResult1);
		request.setAttribute("nowDate", nowDate);
		request.setAttribute("compResult2", compResult2);
		
		return "result.jsp";
	}
}
