package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TypeConvert {

	// テーブルに日付型データを挿入する際に必要
	public java.sql.Date stringToSQLDate(String stringDate) {
		java.sql.Date sqlDate = null;

		sqlDate = java.sql.Date.valueOf(stringDate);

		return sqlDate;
	}

	// テーブルから取り出したデータを文字列に変換
	public String sqlDateToString(java.sql.Date sqlDate) {
		String stringDate = null;

		stringDate = sqlDate.toString();

		return stringDate;
	}

	// 日時を比較する際に必要
	public Calendar stringToCalendar(String stringDate) {
		Calendar calendarDate = null;

		// 一旦、文字列をjava.util.Date型へ
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date eventDate = null;
		try {
			eventDate = sf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// java.util.DateをCalendarへ
		calendarDate = Calendar.getInstance();
		calendarDate.setTime(eventDate);

		return calendarDate;
	}

	// 日時を比較する
	public String compareCalendar(Calendar calendarDate) {
		// 現在日時の分秒ミリ秒を0にする
		calendarDate.set(Calendar.MINUTE, 0);
		calendarDate.set(Calendar.SECOND, 0);
		calendarDate.set(Calendar.MILLISECOND, 0);

		// 比較用のオブジェクトに現在日時をコピー
		Calendar calendarComp = (Calendar) calendarDate.clone();
		calendarComp.set(Calendar.HOUR_OF_DAY, 14); // 14時以降か比較する場合

		// 日時の比較
		// 戻り値が0なら一致、正なら現在日時が指定日時を過ぎている、負なら現在日時は指定日時より前
		int compareResult = calendarDate.compareTo(calendarComp);

		if (compareResult >= 0) {
			return "14時以降です";
		} else {
			return "14時より前です";
		}
	}
}
