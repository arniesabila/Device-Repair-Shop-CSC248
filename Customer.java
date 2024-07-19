public class Customer
{
    private String custName, custID;
    private String custPhoneNo; // put reminder in app to ask customer to input without space
    private String custEmail;
    protected DamageTicket dmgtkt;
    protected Technician tech;
    
    public Customer(String cn, String cp, String ci, String ce)
    {
        this.custName = cn;
        this.custPhoneNo = cp;
        this.custID = ci;
        this.custEmail =ce;
        this.dmgtkt = null;
    }
    
    public void setCustName(String cn){this.custName = cn;}
    public void setCustPhoneNo(String cp){this.custPhoneNo = cp;}
    public void setCustID(String ci){this.custID = ci;}
    public void setCustEmail(String ce){this.custEmail = ce;}
    
    public String getCustName(){return this.custName;}
    public String getCustPhone(){return this.custPhoneNo;}
    public String getCustID(){return this.custID;}
    public String getCustEmail(){return this.custEmail;}

    public DamageTicket getDamageTicket() {
        return this.dmgtkt;
    }
    
    public DamageTicket setDamageTicket(DamageTicket ticket) {
        return this.dmgtkt;
    }
    
    public Technician getTechnician()
    {
        return this.tech;
    }

    public String toString()
    {
        return "Customer Name: "+this.custName+"\n"+
               "Customer Phone No: "+this.custPhoneNo+"\n"+
               "Customer ID: "+this.custID+"\n"+
               "Customer Email: "+this.custEmail;
    }
    
    public String writeToString() {
        
        return this.custName+ "," +this.custPhoneNo+
               "," +this.custID+ "," +this.custEmail;
    }
}
