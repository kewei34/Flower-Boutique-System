import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Member extends AccDetails{

private String username;
private int point;
private static int countMember = 2;

    public Member(){
        super();
        this.username = "";
        this.point = 0;
    }

    public Member(String id,String pw,String name,char gender,String phoneNo,String email,String username,int point){

        super(id,pw,name,gender,phoneNo,email);
        this.username = username;
        this.point = point;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.pw;
        }

        public int getPoint(){
            return this.point;
        }

    // generate member ID
    public String countID() {

        if (countMember < 10) {
            return String.format("M" + "00" + countMember);
        } else if(countMember<100)
            return String.format("M" + "0" + countMember);
         else
         return String.format("M" + countMember);
    }

    public Member[] add(Member[] memberArr,String pw,String name,char gender,String phoneNo,String email,String username,int point ) {

        //use array list as temporary storage
        List<Member> newMember= new ArrayList<Member>();    
        Collections.addAll(newMember, memberArr);
        Member[] temp = new Member[memberArr.length+1];

        //update new product
        temp[memberArr.length]= new Member(countID(),pw,name,gender,phoneNo,email,username,point);
        newMember.add(temp[memberArr.length]);

        //convert to array
        memberArr = newMember.toArray(memberArr);

        countMember++;
        return memberArr;
    }

    public String toString(){

        return String.format("Member ID   : %s\nName        : %s\n,Username    : %s\nPassword    : %s\nGender      : %c\nPhone No    : %s\nEmail       : %s\nPoint       : %d",countID(),name,username,pw,gender,phoneNo,email,point);
    }

    public void display(Member[] memberArr,int no){

        System.out.printf("Member ID   : %s\nName        : %s\nUsername    : %s\nPassword    : %s\nGender      : %c\nPhone No    : %s\nEmail       : %s\nPoint       : %d",memberArr[no].id,memberArr[no].name,memberArr[no].username,memberArr[no].pw,memberArr[no].gender,memberArr[no].phoneNo,memberArr[no].email,memberArr[no].point);
    }



    public int search(Member[] memberArr,String id){

        for(int i=0;i<memberArr.length;i++){
        if(id.equals(memberArr[i].id)){
            return i;
        }
        else {
            if(i==memberArr.length){
                return -1;
            }
            else
            continue;
        }
        }
        return -1;

    }
}