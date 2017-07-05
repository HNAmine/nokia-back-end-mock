/**
 * 
 */
package nokia.org.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hamza
 *
 */
public class FormDto {
	
	private String siteCode;
	private String siteName;
	private MultipartFile photo1;
	private MultipartFile photo2;
	
	
	public FormDto() {
		super();
	}
	public FormDto(String siteCode, String siteName, MultipartFile photo1, MultipartFile photo2) {
		super();
		this.siteCode = siteCode;
		this.siteName = siteName;
		this.photo1 = photo1;
		this.photo2 = photo2;
	}
	/**
	 * @return the siteCode
	 */
	public String getSiteCode() {
		return siteCode;
	}
	/**
	 * @param siteCode the siteCode to set
	 */
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * @return the photo1
	 */
	public MultipartFile getPhoto1() {
		return photo1;
	}
	/**
	 * @param photo1 the photo1 to set
	 */
	public void setPhoto1(MultipartFile photo1) {
		this.photo1 = photo1;
	}
	/**
	 * @return the photo2
	 */
	public MultipartFile getPhoto2() {
		return photo2;
	}
	/**
	 * @param photo2 the photo2 to set
	 */
	public void setPhoto2(MultipartFile photo2) {
		this.photo2 = photo2;
	}
	
	

}
