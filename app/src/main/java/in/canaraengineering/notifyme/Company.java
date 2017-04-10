package in.canaraengineering.notifyme;

/**
 * Created by USER on 4/9/2017.
 */

public class Company {
    private String CompanyName;
    private String CompanyVenue;
    private String CompanyPackage;


    public Company( ){

    }

    public Company(String CompanyName,String CompanyVenue,String CompanyPackage){        // company constructor with paramenter
        this.CompanyName = CompanyName;
        this.CompanyPackage = CompanyPackage;
        this.CompanyVenue = CompanyVenue;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getCompanyVenue() {
        return CompanyVenue;
    }

    public void setCompanyVenue(String CompanyVenue) {
        this.CompanyVenue = CompanyVenue;
    }

    public String getCompanyPackage() {
        return CompanyPackage;
    }

    public void setCompanyPackage(String CompanyPackage) {
        this.CompanyPackage = CompanyPackage;
    }

}
