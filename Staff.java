public class Staff extends AccDetails{

    protected String position;
    protected double salary;
    private static int countStaff = 2;

    public Staff(){
        super();
        this.position = "";
        this.salary = 0.0;
    }

    public Staff(String id,String pw,String name,char gender,String phoneNo,String email,String position,double salary){
        super(id,pw,name,gender,phoneNo,email);
        this.position = position;
        this.salary = salary;
    }

    // generate staff ID
    public String countID() {
        countStaff++;
        if (countStaff < 10) {
            return String.format("S" + "00" + countStaff);
        } else if(countStaff<100)
            return String.format("S" + "0" + countStaff);
         else
         return String.format("S" + countStaff);
    }

    public String toString(){
        return String.format("Staff ID    : %s\nName        : %s\nPassword    : %s\nGender      : %c\nPhone No    : %s\nEmail       : %s\nSalary      : %.2f\nPosition    : %s\n",this.id,name,pw,gender,phoneNo,email,salary,position);
    }
    

    public String getID(){
        return this.id;
    }

    public String getPassword(){
        return this.pw;
        }

    public int search(Staff[] staffArr,String id){

            for(int i=0;i<staffArr.length;i++){
            if(id.equals(staffArr[i].id)){
                return i;
            }
            else {
                if(i==staffArr.length){
                    return -1;
                }
                else
                continue;
            }
            }
            return -1;
    
        }
}
