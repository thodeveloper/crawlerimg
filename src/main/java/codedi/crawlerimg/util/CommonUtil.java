package codedi.crawlerimg.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

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

	public static void uploadFileToS3() throws FileNotFoundException {
		String accessKey = "insert your access key here!";
		String secretKey = "insert your secret key here!";
		String existingBucketName = "<your Bucket Name>";
		String keyName = "mypic.JPG";

		String filePath = "E://Pics//mypic.JPG";
		String amazonFileUploadLocationOriginal = existingBucketName + "/";

		AWSCredentials credentials = new BasicAWSCredentials(accessKey,
				secretKey);
		AmazonS3 s3Client = new AmazonS3Client(credentials);

		FileInputStream stream = new FileInputStream(filePath);
		ObjectMetadata objectMetadata = new ObjectMetadata();
		PutObjectRequest putObjectRequest = new PutObjectRequest(
				amazonFileUploadLocationOriginal, keyName, stream,
				objectMetadata);
		PutObjectResult result = s3Client.putObject(putObjectRequest);
		System.out.println(result);
	}
}
