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
		String accessKey = "AKIAJHE7GDTTGGGO3DNA";
		String secretKey = "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";
		String existingBucketName = "xkcn2014";
		String keyName = "tumblr_ndfissHarR1qbd81ro1_1280.jpg";

		String filePath = "D://Workspace/crawlerimg/tumblr_ndfissHarR1qbd81ro1_1280.jpg";
		String amazonFileUploadLocationOriginal = existingBucketName;

		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		AmazonS3 s3Client = new AmazonS3Client(credentials);

		FileInputStream stream = new FileInputStream(filePath);
		ObjectMetadata objectMetadata = new ObjectMetadata();
		PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, stream, objectMetadata);
		PutObjectResult result = s3Client.putObject(putObjectRequest);
		System.out.println(result);
	}
}
