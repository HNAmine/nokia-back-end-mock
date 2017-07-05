/**
 * 
 */
package nokia.org.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nokia.org.dto.FormDto;

/**
 * @author Hamza
 *
 */
@RestController
@CrossOrigin
public class FormController {

	@Value("${files-path}")
	private String path;

	@PostMapping("/upload")
	public boolean pictureupload(@RequestParam("FormDto") FormDto form) {
		try {
			Path downloadedPhoto1 = Paths.get(form.getPhoto1().getOriginalFilename());
			Files.deleteIfExists(downloadedPhoto1);
			Files.copy(form.getPhoto1().getInputStream(), downloadedPhoto1);
			Path downloadedPhoto2 = Paths.get(form.getPhoto1().getOriginalFilename());
			Files.deleteIfExists(downloadedPhoto2);
			Files.copy(form.getPhoto1().getInputStream(), downloadedPhoto2);

			return true;
		} catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).error("picture upload", e);
			return false;
		}
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downLoadFile(HttpServletResponse response) throws IOException {
		File fileToDownLoad = null;
		String filePath = "";
		URL url = null;
		url = getClass().getClassLoader().getResource("/");
		filePath = url.getFile() + path;
		fileToDownLoad = new File(filePath + "RAPPORT.xls");
		if (!fileToDownLoad.exists()) {
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		String mimeType = URLConnection.guessContentTypeFromName(fileToDownLoad.getName());
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition",
				String.format("inline; filename=\"" + fileToDownLoad.getName() + "\""));
		response.setContentLength((int) fileToDownLoad.length());// byte
		InputStream inputStream = new BufferedInputStream(new FileInputStream(fileToDownLoad));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

}
