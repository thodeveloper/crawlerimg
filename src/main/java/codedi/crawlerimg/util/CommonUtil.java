package codedi.crawlerimg.util;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class CommonUtil {

	public static String generateUniqueString(String prefix, String suffix) {
		String result = "";
		if (!StringUtils.isEmpty(prefix)) {
			result += prefix;
		}

		// Generate unique string
		Date date = new Date();
		result += date.getTime() + "";
		result += RandomStringUtils.randomAlphanumeric(2);

		if (!StringUtils.isEmpty(suffix)) {
			result += suffix;
		}

		return result;
	}

}
