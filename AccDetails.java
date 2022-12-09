
public abstract class AccDetails{

    protected String id;
    protected String pw;
    protected String name;
    protected char gender;
    protected String phoneNo;
    protected String email;

    public AccDetails(){

        this.id = "";
        this.pw = "";
        this.name = "";
        this.gender = '\u0000';
        this.phoneNo = "";
        this.email = "";
    }

    public AccDetails(String id,String pw,String name,char gender,String phoneNo,String email){

        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email= email;
    }



}