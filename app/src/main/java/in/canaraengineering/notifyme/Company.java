package in.canaraengineering.notifyme;

/**
 * Created by USER on 4/8/2017.
 */

public   class Company {
    private static String mCompanyName;
    private static String mCompanyDescription;
    private static String mCompanyPackage;

    public  Company(){

    }

    public Company(String CompanyName,String CompanyDescription,String CompanyPackage){

        mCompanyName = CompanyName;
        mCompanyDescription  = CompanyDescription;
        mCompanyPackage  = CompanyPackage;


    }



    public static String getmCompanyName() {
        return mCompanyName;
    }

    public  void setmCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }

    public String getmCompanyDescription() {
        return mCompanyDescription;
    }

    public void setmCompanyDescription(String mCompanyDescription) {
        this.mCompanyDescription = mCompanyDescription;
    }

    public static String getmCompanyPackage() {
        return mCompanyPackage;
    }

    public void setmCompanyPackage(String mCompanyPackage) {
        this.mCompanyPackage = mCompanyPackage;
    }






}
