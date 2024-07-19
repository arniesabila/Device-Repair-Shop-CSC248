public class DamageTicket
{
    private int dmgLevel; // 1-low, 2-medium, 3-severe
    private String dmgType; // "Hardware", "Software"
    private int repairStatus; //initialize to 0 since all newly inputted devices are not repaired yet
    protected Customer cust;

    public DamageTicket(int lvl, String dmgt)
    {
        this.dmgLevel = lvl;
        this.dmgType = dmgt;
        this.repairStatus = 0; 
        this.cust = null;
    }
    
    public void setDmgLevel(int lvl){this.dmgLevel = lvl;}
    public void setDmgType(String dmgt){this.dmgType = dmgt;}
    
    public int getDmgLevel(){return this.dmgLevel;}
    public String getDmgType(){return dmgType;}
    public int getRepairStatus(){return this.repairStatus;}
    public void setCustomer(Customer customer){this.cust = customer;}
    public Customer getCustomer(){return this.cust;}
    
    public void updateStatus( int newStat)
    {
        if(newStat >=0 && newStat <=2){
            this.repairStatus = newStat;
            if(newStat == 0){
                System.out.println("Repair status updated to: Pending");
            }else if(newStat == 1){
                System.out.println("Repair status updated to: In Progress");
            }else if(newStat == 2){
                System.out.println("Repair status updated to: Completed");
            }
        }
    }
    
    

}
