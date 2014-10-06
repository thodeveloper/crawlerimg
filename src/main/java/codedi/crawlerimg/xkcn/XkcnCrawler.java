package codedi.crawlerimg.xkcn;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class XkcnCrawler {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://xkcn.info").get();
		Elements newsHeadlines = doc.select("div.gridItem");

		for (Element element : newsHeadlines) {

			System.out.println(element.attr("data-photo-high"));
			String url = element.attr("data-photo-high");
			String baseName = FilenameUtils.getBaseName(url);
			String extension = FilenameUtils.getExtension(url);

			downloadUsingNIO(element.attr("data-photo-high").toString(),
					baseName + "." + extension);
		}
	}

	private static void downloadUsingNIO(String urlStr, String file)
			throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}
}
