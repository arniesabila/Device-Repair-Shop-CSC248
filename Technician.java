
public class Technician
{
    private String techName;
    private String techID;
    private String techSpec;  // Computer/Phone/Tablet
    private String techAvail; 
    protected DamageTicket dmgtkt;
    protected Customer cust;
    protected DeviceInventory inventory;
    
    public Technician(String tn, String ti, String ts, String ta){
        this.techName = tn;
        this.techID = ti;
        this.techSpec = ts;
        this.techAvail = ta;
    }
    
    public void setTechName(String tn){
        this.techName = tn;
    }
    public void setTechID(String ti){
        this.techID = ti;
    }
    public void setTechSpec(String ts){
        this.techSpec = ts;
    }
    public void setAvail(String ta) {
        this.techAvail = ta;
    }
    
    public String getTechName(){
        return this.techName;
    }
    public String getTechID(){
        return this.techID;
    }
    public String getTechSpec(){
        return this.techSpec;
    }
    public String getTechAvail(){
        return this.techAvail;
    }
     
     public void setCustomer(Customer customer) {
        this.cust = customer;
    }
    
     public Customer getCustomer() {
        return this.cust;
    }
    
    public DamageTicket getDamage()
    {
        return this.dmgtkt;
    }
    
    public DeviceInventory inventory()
    {
        return this.inventory;
    }
    //Methods   
    
    public String toString() {
        return "Technician: " + "Name: " + techName + ", Technician ID:" + techID + ", Specialization: " + techSpec + ", Availability: " + techAvail;
    }
    public String writeToString(){
        return this.techName+ "," +this.techID+ "," +this.techSpec+ "," +this.techAvail;
    }
}
