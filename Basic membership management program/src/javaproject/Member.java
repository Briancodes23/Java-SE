package javaproject;

//Member class will contain all basic info about each member
public class Member {
    
    char memberType;
    int memberID;
    String name;
    double fees;
    
    /*Creating a constructor for the member class*/
    /*private fields char, int, String, double*/
    Member(char pMemberType, int pMemberID, String pName, double pFees){
    
        /*Assigning the four parameters to the appropriate fields*/
        memberType = pMemberType;
        memberID = pMemberID;
        name = pName;
        fees = pFees;               
    }
    
    /*Creating the setter and getter methods for the four private fields*/
    /*All the methods will be public*/
    public void setMemberType(char pMemberType)
    {
        memberType = pMemberType;
    }
    
    public char getMemberType()
    {
        return memberType;
    }
    
    public void setMemberID(int pMemberID)
    {
        memberID = pMemberID;
    }
    
    public int getMemberID()
    {
        return memberID;
    }
    
     public void setName(String pName)
    {
        name = pName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setFees(double pFees)
    {
        fees = pFees;
    }
    
    public double getFees()
    {
        return fees;
    }

    @Override
    public String toString(){
       return memberType + ", " + memberID + ", " + name + ", " + fees;
    }

}
