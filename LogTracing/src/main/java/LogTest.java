import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;


public class LogTest {

	public static void main(String[] args) {
		File file = new File("App.log");

		String content = null;
		String line = null;

		DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate lDt = LocalDate.parse("2023-07-02", DATEFORMATTER);
		try {
			List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
			// lines.forEach(System.out::println);
			/* Date Wise Log */
			/*
			 * String strDateRegEx = "\\d{4}-\\d{2}-\\d{2}"; lines.stream().filter((x)->{
			 * x=x.substring(0, 10); if(x.matches(strDateRegEx)){ LocalDate filteredDt =
			 * LocalDate.parse(x,DATEFORMATTER); return filteredDt.isEqual(lDt); }else{
			 * return false; } }).forEach(System.out::println);
			 */
			/* Date Wise Log End */
			/* ===================================== */
			/* Keyword Wise */
			/*
			 * String kw="hdnEncrypt"; lines.stream().filter((x)->{ return x.contains(kw);
			 * }).forEach(System.out::println);
			 */
			/* Keyword Wise End */
			/* ===================================== */

			Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
			lines.stream().filter((x) -> {
				Matcher m = p.matcher(x);
				if (m.find()) {
					LocalDate filteredDt = LocalDate.parse(m.group());
					return filteredDt.isEqual(lDt);
				} else {
					return false;
				}
			}).forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println(content);
	}

}