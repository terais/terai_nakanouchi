import java.util.Calendar;

public class Test{
	public static void main(String[] args) throws Exception {
		Calendar cal = Calendar.getInstance();
		String y = String.valueOf(cal.get(cal.YEAR));
		String m = String.valueOf(cal.get(cal.MONTH));
		String d = String.valueOf(cal.get(cal.DATE));
		String result = "";
		int mm = Integer.parseInt(m);
		m = String.valueOf(mm + 1);
		if (args[0].equals("今日")) {
			int dd = Integer.parseInt(d);
			d = String.valueOf(dd + 1);
			result = String.valueOf(y + "/" + m + "/" + d);
		} else if (args[0].equals("明日")) {
			int dd = Integer.parseInt(d);
			d = String.valueOf(dd + 2);
			result = String.valueOf(y + "/" + m + "/" + d);
		} else if (args[0].equals("昨日")) {
			result = String.valueOf(y + "/" + m + "/" + d);
		} else {
			result = "error";
		}
		System.out.println(result);
	}
}