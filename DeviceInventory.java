public class DeviceInventory{    
    private String deviceType,deviceModel, deviceID;  
    private String manufacturer;  
    private boolean warrantyStat;
    protected Customer cust;
    protected Technician tech;
    
    public DeviceInventory(String devType ,String devModel,String manu, String devID ,boolean warStat){
        this.deviceType = devType;
        this.deviceModel = devModel;  
        this.manufacturer = manu;
        this.deviceID = devID;  
        this.warrantyStat = warStat;
        this.cust = null;
    }
    public void setDeviceType (String devType){
         this.deviceType = devType;
    }
    public void setDeviceModel (String devModel){
        this.deviceModel = devModel;  
    }    
    public void setManufacturer (String manu){
        this.manufacturer = manu;
    }
    public void setDeviceID (String devID){
        this.deviceID = devID;
    }
    public void setWarrantyStat (boolean warStat){
        this.warrantyStat = warStat;
    }
    
    public String getDeviceType(){
        return this.deviceType;
    }
    public String getDeviceModel(){
        return this.deviceModel;
    }    
    public String getManufacturer(){
        return this.manufacturer;
    }    
    public String getDeviceID(){
        return this.deviceID;
    }    
    public boolean getWarrantyStat( boolean warStat ){
        return this.warrantyStat;
    }
    
    public Customer getCustomer()
    {
        return this.cust;
    }
    
    public Technician getTechnician()
    {
        return this.tech;
    }
    
    public String toString(){
        return "Device Type : " + this.deviceType +"\n"+
               "Device Model : " + this.deviceModel +"\n"+
               "Manufacturer : " + this.manufacturer +"\n"+
               "Device ID : " + this.deviceID +"\n"+
               "Warranty Status : " + this.warrantyStat;
    }
    
    public String writeToString() {
        
        return this.deviceModel+ "," +this.deviceType+
               "," +this.manufacturer+ "," +this.deviceID+
               "," +this.warrantyStat;
    }
}
