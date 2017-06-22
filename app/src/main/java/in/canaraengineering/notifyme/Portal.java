package in.canaraengineering.notifyme;


    public class Portal {
    private String CompanyName;
    private String CompanyPackage;
    private String CompanyVenue;
    public Portal(String CompanyName,String CompanyPackage,String CompanyVenue){
        this.CompanyName = CompanyName;
        this.CompanyPackage = CompanyPackage;
        this.CompanyVenue = CompanyVenue;
    }
    public Portal(){

    }
    public String getCompanyName(){
        return CompanyName;
    }
    public String getCompanyPackage(){
        return CompanyPackage;
    }
    public String getCompanyVenue(){
        return CompanyVenue;
    }

}
