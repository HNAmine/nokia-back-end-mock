package nokia.org.dto;

public class Repport {

	private String siteCode;
	private String siteName;
	private String repportUrl;

	public Repport(String siteCode, String siteName, String repportUrl) {
		super();
		this.siteCode = siteCode;
		this.siteName = siteName;
		this.repportUrl = repportUrl;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getRepportUrl() {
		return repportUrl;
	}

	public void setRepportUrl(String repportUrl) {
		this.repportUrl = repportUrl;
	}

}
