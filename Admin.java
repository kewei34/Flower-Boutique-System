import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Admin extends Staff {
    

    //add new staff
    public Staff[] add(Staff[] staffArr,String id,String pw,String name,char gender,String phoneNo,String email,String position,double salary) {

        //use array list as temporary storage
        List<Staff> newStaff= new ArrayList<Staff>();    
        Collections.addAll(newStaff, staffArr);
        Staff[] temp = new Staff[staffArr.length+1];

        //update new product
        temp[staffArr.length]= new Staff(id,pw,name,gender,phoneNo,email,position,salary);
        newStaff.add(temp[staffArr.length]);

        //convert to array
        staffArr = newStaff.toArray(staffArr);

        return staffArr;
        
    }


    
}
