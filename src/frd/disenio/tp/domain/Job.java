package frd.disenio.tp.domain;

// clase con los atributos que posee un trabajo segun el json y los accessors para cada uno.
public class Job {
	private String city;
	private String company;
	private String companyDetailsURL;
	private String country;
	private String distance;
	private String documentID;
	private String employmentType;
	private String highlight;
	private String jobDetails;
	private String jobDetailsURL;
	private String jobServiceURL;
	private String jobTitle;
	private String location;
	private String locationLat;
	private String locationLon;
	private String pay;
	private String postedDate; 
	private boolean showSocCode;
	private String similarJobsURL;
	private String socCode;
	private String source;
	private String state;
	
	// accessors 
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyDetailsURL() {
		return companyDetailsURL;
	}
	public void setCompanyDetailsURL(String companyDetailsURL) {
		this.companyDetailsURL = companyDetailsURL;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getDocumentID() {
		return documentID;
	}
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getHighlight() {
		return highlight;
	}
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	public String getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}
	public String getJobDetailsURL() {
		return jobDetailsURL;
	}
	public void setJobDetailsURL(String jobDetailsURL) {
		this.jobDetailsURL = jobDetailsURL;
	}
	public String getJobServiceURL() {
		return jobServiceURL;
	}
	public void setJobServiceURL(String jobServiceURL) {
		this.jobServiceURL = jobServiceURL;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocationLat() {
		return locationLat;
	}
	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}
	public String getLocationLon() {
		return locationLon;
	}
	public void setLocationLon(String locationLon) {
		this.locationLon = locationLon;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	public boolean isShowSocCode() {
		return showSocCode;
	}
	public void setShowSocCode(boolean showSocCode) {
		this.showSocCode = showSocCode;
	}
	public String getSimilarJobsURL() {
		return similarJobsURL;
	}
	public void setSimilarJobsURL(String similarJobsURL) {
		this.similarJobsURL = similarJobsURL;
	}
	public String getSocCode() {
		return socCode;
	}
	public void setSocCode(String socCode) {
		this.socCode = socCode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
