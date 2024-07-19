import java.util.*;
import java.io.*;
public class ElectronicRepairLinkedListApp
{
    public static int size;
    //cust interface  
    public static void customerInfo(LinkedList custList)
    {
        try{
            readFileCust(custList);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        
        Scanner inline = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter customer name              : ");
        String custName = inline.nextLine();
        System.out.print("Enter phone number (No Space)    : ");
        String custPhoneNo = in.next();
        System.out.print("Enter customer ID                : ");
        String custID= inline.nextLine();
        System.out.print("Enter email                      : ");
        String custEmail = inline.nextLine();

        Customer cust = new Customer(custName, custPhoneNo, custID, custEmail);
        System.out.println("\u000C");
        custList.addLast(cust);
        System.out.println(cust.toString());
        
        //damage ticket
        System.out.print("Damage level (1-low, 2-medium, 3-severe) : ");
        int dmgLevel = in.nextInt();
        System.out.print("Damage type (Hardware / Software)        : ");
        String dmgType = inline.nextLine();

        DamageTicket ticket = new DamageTicket(dmgLevel, dmgType);
        // Customer customer = new Customer(custName, custPhoneNo, custID, custEmail);

        cust.setDamageTicket(ticket);
        
        try{
            writeFileCust(custList);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    

    }

    public static void technicianInfo(LinkedList techList)
    {
        try{
            readFileTech(techList);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        Scanner inline = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter Technician name             : ");
        String techName = inline.nextLine();
        System.out.print("Enter technician ID    : ");
        String techID = inline.nextLine();
        System.out.print("Specialization (Computer/Phone/Tablet): ");
        String techSpec = inline.nextLine();
        System.out.print("Availability (Y/N)     : ");
        String techAvail = inline.nextLine();


        Technician tech = new Technician(techName, techID, techSpec, techAvail);
        techList.addLast(tech);

        /**System.out.println("Assigning a device to the technician... " + tech.assignDevice(techID));
        System.out.println("Updating availability to 'N'...");
        tech.updateAvail("N");*/

        System.out.println(tech.toString());
        
        try{
            writeFileTech(techList);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    
    }

    //process
    public static void newDevice(LinkedList deviceList) throws Exception
    {
        try{
            readFile(deviceList);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        Scanner inline = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        boolean warStat = false;

        System.out.println();
        //device inventory
        System.out.print("Enter device model          : ");
        String devModel = inline.nextLine();
        System.out.print("Enter device type           : ");
        String devType = inline.nextLine();
        System.out.print("Enter device ID             : ");
        String devID = inline.nextLine();
        System.out.print("Enter device manufacturer   : ");
        String manu = inline.nextLine();
        System.out.print("Warranty (Y/N)?             : ");
        String ws = inline.nextLine();
        if(ws.equalsIgnoreCase("Y")){
            warStat= true;
        }

        DeviceInventory deviceQ = new DeviceInventory(devModel, devType, manu, devID, warStat);
        System.out.println("\n");
        System.out.println(deviceQ.toString());
        deviceList.addLast(deviceQ);
        size++;
        try{
            writeFile(deviceList);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        System.out.print("More record (Y/N)?    :   ");
        String c = in.next();
        if (c.charAt(0) == 'Y' || c.charAt(0) == 'y'){
            newDevice(deviceList);
        }
    }

    public static void  searchRecord(LinkedList deviceList) throws Exception// search device information based on device model
    {
        try{

            readFile(deviceList);

            //System.out.println(list.toString());
            Scanner in = new Scanner (System.in);
            System.out.print("Enter Device id   :");
            String d = in.next();

            DeviceInventory inventory = (DeviceInventory)deviceList.getFirst();
            while(inventory != null)
            {
                //System.out.println(inventory.toString());
                if(inventory.getDeviceID().equalsIgnoreCase(d))
                {
                    System.out.println(inventory.toString());
                }
                 inventory = (DeviceInventory)deviceList.getNext();   
            }

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void readFile(LinkedList deviceList) throws Exception
    {
        try
        {
            BufferedReader br = new BufferedReader (new FileReader (new File("RepairShop.txt")));
            String data = br.readLine();
            //System.out.println(data);
            while (data != null)
            {
                StringTokenizer parse = new StringTokenizer (data, ",");
                boolean warStat = false;
                String devModel = parse.nextToken();
                String devType = parse.nextToken();
                String manu = parse.nextToken();
                String devID = parse.nextToken();
                String ws = parse.nextToken();
                if(ws.equalsIgnoreCase("Y")){
                    warStat = true;
                }
                DeviceInventory temp = new DeviceInventory (devModel, devType, manu, devID, warStat);
                deviceList.addLast(temp);
                data = br.readLine();
                //System.out.println(data);
            }
            br.close();
        }
        catch (Exception e) {}
    }
    
    public static void readFileTech(LinkedList techList) throws Exception
    {
        try
        {
            BufferedReader br = new BufferedReader (new FileReader (new File("technicianRepairShop.txt")));
            String data = br.readLine();
            //System.out.println(data);
            while (data != null)
            {
                StringTokenizer parse = new StringTokenizer (data, ",");
                boolean warStat = false;
                String techName = parse.nextToken();
                String techID = parse.nextToken();
                String techSpec = parse.nextToken();
                String techAvail = parse.nextToken();
                Technician temp = new Technician (techName, techID, techSpec, techAvail);
                techList.addLast(temp);
                data = br.readLine();
                //System.out.println(data);
            }
            br.close();
        }
        catch (Exception e) {}
    }
    
    public static void readFileCust(LinkedList custList) throws Exception
    {
        try
        {
            BufferedReader br = new BufferedReader (new FileReader (new File("customerInfoRepairShop.txt")));
            String data = br.readLine();
            //System.out.println(data);
            while (data != null)
            {
                StringTokenizer parse = new StringTokenizer (data, ",");
    
                String custName = parse.nextToken();
                String custPhone = parse.nextToken();
                String custID = parse.nextToken();
                String custEmail = parse.nextToken();
               
                Customer temp = new Customer (custName, custPhone, custID, custEmail);
                custList.addLast(temp);
                data = br.readLine();
                //System.out.println(data);
            }
            br.close();
        }
        catch (Exception e) {}
    }

    public static void writeFile(LinkedList deviceList) throws Exception
    {
        try
        {
            PrintWriter pw = new PrintWriter (new FileWriter(new File("RepairShop.txt")));

            /***
            for(int x = 0; x<size; x++)
            {
            pw.println(device.writeToString());
            }
             **/

            DeviceInventory d = (DeviceInventory) deviceList.getFirst();
            while (d != null) {
                pw.println(d.writeToString());
                d = (DeviceInventory) deviceList.getNext();
            }

            pw.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static void writeFileCust(LinkedList custList) throws Exception
    {
        try
        {
            PrintWriter pw = new PrintWriter (new FileWriter(new File("customerInfoRepairShop.txt")));

            /***
            for(int x = 0; x<size; x++)
            {
            pw.println(device.writeToString());
            }
             **/

            Customer cust = (Customer)custList.getFirst();
            while (cust != null) {
                pw.println(cust.writeToString());
                cust = (Customer)custList.getNext();
            }

            pw.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static void writeFileTech(LinkedList techList) throws Exception
    {
        try
        {
            PrintWriter pw = new PrintWriter (new FileWriter(new File("technicianRepairShop.txt")));

            /***
            for(int x = 0; x<size; x++)
            {
            pw.println(device.writeToString());
            }
             **/

            Technician tech = (Technician)techList.getFirst();
            while (tech != null) {
                pw.println(tech.writeToString());
                tech = (Technician)techList.getNext();
            }

            pw.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    
    public static void updateCustEmail (LinkedList custList) throws Exception//update email customer based on cust ID
    {
        Scanner in = new Scanner (System.in);
        try{
            readFileCust(custList);
            
            System.out.println("Enter customer ID :");
            String d = in.next();
            
            //System.out.println(list.toString());
            Customer cust = (Customer)custList.getFirst();
            while(cust != null)
            {
                //DamageTicket damage = (DamageTicket)list.getFirst();
                if(cust.getCustID().equalsIgnoreCase(d))
                {
                    System.out.print("Enter New Email    :");
                    String e = in.next();
                    cust.setCustEmail(e);
                    break;
                }
                
                cust = (Customer)custList.getNext();
            }
            System.out.println("New Email Have Been Updated!    :");
            writeFileCust(custList);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void techTraverse(LinkedList techList) 
    {
        try{
            readFileTech(techList);
            Technician tech = (Technician)techList.getFirst();
            
            while(tech != null)
            {
                tech = (Technician)techList.getNext();
                 System.out.println(tech.toString());
                 //tech = (Technician)techList.getNext();
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void calcTotalDevice(LinkedList deviceList)
    {
        
        int Countdevice = 0;
        
        DeviceInventory inventory = (DeviceInventory)deviceList.getFirst();
        while(inventory != null)
        {
            Countdevice++;
            inventory = (DeviceInventory)deviceList.getNext();
        }
        System.out.println("Total Device is  :" + Countdevice);
        

    }
    

    public static void RemoveTechInfo(LinkedList techList)
    {
        try{
            readFileTech(techList);
            Scanner in = new Scanner (System.in);
            System.out.print("Enter Tech ID    :");
            String d = in.nextLine();

        Technician tech = (Technician)techList.getFirst();
        while(tech != null)
        {
            if(tech.getTechID().equalsIgnoreCase(d))
            {
                tech = (Technician)techList.removeFirst();
            }
            tech = (Technician)techList.getNext();
            //writeFileTech(techList);
        }
        System.out.println("Record Have Been Remove!");
        writeFileTech(techList);
    }catch(Exception e){
        System.err.println(e.getMessage());
    }
    }

    public static void main(String [] args)
    {
        LinkedList deviceList = new LinkedList();
        LinkedList custList = new LinkedList();
        LinkedList techList = new LinkedList();
        Scanner in = new Scanner (System.in);
        boolean isCont = false;

        while(!isCont)
        {
            System.out.println("================================================================");
            System.out.println("\n\tMENU");
            System.out.println("----------------------------");
            System.out.println("CHOOSE STATUS");
            System.out.println("[C] CUSTOMER");
            System.out.println("[T] TECHNICIAN");
            System.out.println("[X] EXIT");
            System.out.println("================================================================");

            System.out.println("Enter choice    :");
            String choice = in.next();

            System.out.println("\u000C");
            if (choice.toUpperCase().charAt(0) == 'C') 
            { //customer's interface
                System.out.println("================================================================");
                System.out.println("[N] ENTER NEW DEVICE");
                System.out.println("[X] EXIT");
                System.out.println("================================================================");

                System.out.print("Enter choice              :   ");
                String opt = in.next();
                System.out.println("\u000C");
                if (opt.toUpperCase().charAt(0) == 'N') {
                    try{
                        customerInfo(custList);
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                    
                    try{
                        newDevice(deviceList);
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                }
                else if (opt.toUpperCase().charAt(0) == 'X') {
                    isCont = true;
                }
                else {
                    System.out.println("Invalid key!");
                    isCont = false;
                }
            }else if (choice.toUpperCase().charAt(0) == 'T') 
            { //technician's interface
                technicianInfo(techList);
                boolean isC = false;
                while(!isC)
                {
                    
                    System.out.println("================================================================");
                    System.out.println("[S] SEARCH DEVICE");
                    System.out.println("[U] UPDATE EMAIL CUSTOMER");
                    System.out.println("[D] DISPLAY TECHNICIAN");
                    System.out.println("[T] TOTAL DEVICE");
                    System.out.println("[R] REMOVE TECHNICIAN");
                    System.out.println("[X] EXIT");
                    System.out.println("================================================================");

                    System.out.print("Enter choice              :   ");
                    String opt = in.next();

                    if(opt.toUpperCase().charAt(0) == 'S') {
                        try{searchRecord(deviceList);}
                        catch (Exception e){e.getMessage();}
                    }
                    else if (opt.toUpperCase().charAt(0) == 'U') {
                        try{updateCustEmail(custList);}
                        catch (Exception e){e.getMessage();}
                    }
                    else if (opt.toUpperCase().charAt(0) == 'D') {
                        try{techTraverse(techList);}
                        catch (Exception e) {e.getMessage();}
                    }
                    else if (opt.toUpperCase().charAt(0) == 'T') {
                        calcTotalDevice(deviceList);
                    }
                    else if (opt.toUpperCase().charAt(0) == 'R') {
                        RemoveTechInfo(techList);
                    }
                     else if (opt.toUpperCase().charAt(0) == 'X') {
                        isC = true;
                    }
                    
                    else {
                        System.out.println("Invalid key!");
                        isCont = false;
                    }
                }
            }else if (choice.toUpperCase().charAt(0) == 'X') {
                isCont = true;
            }
        }
    }
}
