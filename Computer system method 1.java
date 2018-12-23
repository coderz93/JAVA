package computer;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JDialog;

public class Computer {
    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        String input,st,product,category,services,productchosen = "",serviceschosen = "";
        int discount,quantity = 0,choose;
        double price,total,totalprice = 0,grandtotal = 0;
        boolean y = true;
        DecimalFormat x = new DecimalFormat("#0.00");
        String[] selectType = {"Product","Services"};
        String[] productCategory = {"Accessory","Charger","Gadget","Computer components for Desktop"};
        String[] accessoryCategory = {"Laptop Skin","Keyboard Protector","Keyboard Sticker"};
        String[] chargerCategory = {"HP","Acer","ASUS","Universal"};
        String[] gadgetCategory = {"Mouse","Mouse (Wireless)","Cooler pad (Laptop)","Keyboard"};
        String[] componentCategory = {"Motherboard","Hard disk","Power supply unit","RAM DDR2 (1GB)","RAM DDR2 (2GB)","RAM DDR3 (2GB)","RAM DDR3 (4GB)","Body case"};
        String[] servicesCategory = {"Formatting","Data recovery","Maintenance","Office utilities","Data backup"};
        String[] formatCategory = {"Windows XP","Windows 7","Windows 8","Windows 10"};
        String[] recoveryCategory = {"8GB","20 GB","100 GB"};
        String[] maintenanceCategory = {"Printer","Laptop","Compuer (Desktop)"};
        String[] utilitiesCategory = {"Printing Color","Printing Black","Fax(1st page)","Fax(2nd pages)","Photocopy","Binding"};
        String[] backupCategory = {"20 GB","50 GB","100 GB"};
        
        input = (String)JOptionPane.showInputDialog(null,"WELCOME TO EAST COAST GM RESOURCES\nYou are required to follow the instruction in assuring the system to work properly.\n\nEnter membership [Y] for Yes @ [N] for No:","Ecgmr",JOptionPane.QUESTION_MESSAGE);
        while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
            input = (String)JOptionPane.showInputDialog(null,"WELCOME TO EAST COAST GM RESOURCES\nYou are required to follow the instruction in assuring the system to work properly.\n\nEnter membership [Y] for Yes @ [N] for No:","Ecgmr",JOptionPane.ERROR_MESSAGE);
        }
        if(input.equals("y")||input.equals("Y")){
            discount = 10;
        }else{
            discount = 0;
        }
        st = (String)JOptionPane.showInputDialog(null,"Choose business type","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,selectType,selectType[0]);
        if(st.equals(selectType[0])){
            do{
                product = (String)JOptionPane.showInputDialog(null,"Choose Product","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,productCategory,productCategory[0]);
                if(product.equals(productCategory[0])){
                    category = (String)JOptionPane.showInputDialog(null,"Choose Accessory","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,accessoryCategory,accessoryCategory[0]);
                    if(category.equals(accessoryCategory[0])){
                        price = 25.00;
                    }else if(category.equals(accessoryCategory[1])){
                        price = 10.00;
                    }else{
                        price = 5.00;
                    }
                    category = "Accessory : "+category;
                }else if(product.equals(productCategory[1])){
                    category = (String)JOptionPane.showInputDialog(null,"Choose Charger","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,chargerCategory,chargerCategory[0]);
                    if(category.equals(chargerCategory[0])||category.equals(chargerCategory[1])||category.equals(chargerCategory[2])){
                        price = 75.00;
                    }else{
                        price = 95.00;
                    }
                    category = "Charger : "+category;
                }else if(product.equals(productCategory[2])){
                    category = (String)JOptionPane.showInputDialog(null,"Choose Gadget","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,gadgetCategory,gadgetCategory[0]);
                    if(category.equals(gadgetCategory[0])){
                        price = 15.00;
                    }else if(category.equals(gadgetCategory[1])){
                        price = 35.00;
                    }else{
                        price = 25.00;
                    }
                    category = "Gadget : "+category;
                }else{
                    category = (String)JOptionPane.showInputDialog(null,"Choose Computer Components for Desktop","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,componentCategory,componentCategory[0]);
                    if(category.equals(componentCategory[0])){
                        price = 280.00;
                    }else if(category.equals(componentCategory[1])){
                        price = 300.00;
                    }else if(category.equals(componentCategory[2])||category.equals(componentCategory[3])){
                        price = 75.00;
                    }else if(category.equals(componentCategory[4])){
                        price = 110.00;
                    }else if(category.equals(componentCategory[5])){
                        price = 120.00;
                    }else if(category.equals(componentCategory[6])){
                        price = 200.00;
                    }else{
                        price = 90.00;
                    }
                    category = "Computer Components for Dekstop : "+category;
                }
                do{
                    try{
                        input = (String)JOptionPane.showInputDialog(null,"Product Quantity","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                        quantity = Integer.parseInt(input);
                        if(quantity < 0){
                            JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Product = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(NumberFormatException NFE){
                            JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Product = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                    }
                }while(quantity <= 0);
                total = price * quantity;
                totalprice = totalprice + total;
                productchosen = productchosen + "          - "+category+"          RM "+x.format(price)+" x "+quantity+" = RM "+x.format(total)+"\n";   
                input = (String)JOptionPane.showInputDialog(null,"Do You Want To Buy Another Product ?\n\nEnter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                    input = (String)JOptionPane.showInputDialog(null,"Invalid Input ! Enter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.ERROR_MESSAGE);
                }
            }while(input.equalsIgnoreCase("y")==y);
            choose = JOptionPane.showConfirmDialog(null,"Do You Want To Proceed With Services ?","Ecgmr",JOptionPane.YES_NO_OPTION);
            if(choose == JOptionPane.YES_OPTION){
                do{
                    services = (String)JOptionPane.showInputDialog(null,"Choose Services","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,servicesCategory,servicesCategory[0]);
                    if(services.equals(servicesCategory[0])){
                        category = (String)JOptionPane.showInputDialog(null,"Choose Formatting","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,formatCategory,formatCategory[0]);
                        if(category.equals(formatCategory[0])||category.equals(formatCategory[1])||category.equals(formatCategory[2])){
                            price = 60.00;
                        }else{
                            price = 80.00;
                        }
                        category = "Formatting : "+category;
                    }else if(services.equals(servicesCategory[1])){
                        category = (String)JOptionPane.showInputDialog(null,"Choose Data Recovery","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,recoveryCategory,recoveryCategory[0]);
                        if(category.equals(recoveryCategory[0])){
                            price = 50.00;
                        }else if(category.equals(recoveryCategory[1])){
                            price = 120.00;
                        }else{
                            price = 500.00;
                        }
                        category = "Data Recovery : "+category;
                    }else if(services.equals(servicesCategory[2])){
                        category = (String)JOptionPane.showInputDialog(null,"Choose Maintenance","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,maintenanceCategory,maintenanceCategory[0]);
                        if(category.equals(maintenanceCategory[0])){
                            price = 50.00;
                        }else if(category.equals(maintenanceCategory[1])){
                            price = 80.00;
                        }else{
                            price = 40.00;
                        }
                        category = "Maintenance : "+category;
                    }else if(services.equals(servicesCategory[3])){
                        category = (String)JOptionPane.showInputDialog(null,"Choose Office Utilities","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,utilitiesCategory,utilitiesCategory[0]);
                        if(category.equals(utilitiesCategory[0])||category.equals(utilitiesCategory[3])){
                            price = 1.00;
                        }else if(category.equals(utilitiesCategory[1])){
                            price = 0.30;
                        }else if(category.equals(utilitiesCategory[2])){
                            price = 5.00;
                        }else if(category.equals(utilitiesCategory[4])){
                            price = 0.20;
                        }else{
                            price = 1.50;
                        }
                        category = "Office Utilities : "+category;
                    }else{
                        category = (String)JOptionPane.showInputDialog(null,"Choose Data Backup","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,backupCategory,backupCategory[0]);
                        if(category.equals(backupCategory[0])){
                            price = 40.00;
                        }else if(category.equals(backupCategory[1])){
                            price = 60.00;
                        }else{
                            price = 100.00;
                        }
                        category = "Data Backup : "+category;
                    }
                    do{
                        try{
                            input = (String)JOptionPane.showInputDialog(null,"Services Quantity","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity < 0){
                                JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Services = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException NFE){
                                JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Services = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                        }
                    }while(quantity <= 0);
                    total = price * quantity;
                    totalprice = totalprice + total;
                    serviceschosen = serviceschosen + "          - "+category+"          RM "+x.format(price)+" x "+quantity+" = RM "+x.format(total)+"\n";
                    input = (String)JOptionPane.showInputDialog(null,"Do You Want To Use Another Services ?\n\nEnter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                    while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                        input = (String)JOptionPane.showInputDialog(null,"Invalid Input ! Enter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.ERROR_MESSAGE);
                    }
                }while(input.equalsIgnoreCase("y")==y);
                grandtotal = grandtotal + totalprice - (totalprice * discount/100);
                JOptionPane.showMessageDialog(null,"Product :\n"+productchosen+"\nServices : \n"+serviceschosen+"\n\nTotal Price : RM "+x.format(totalprice)+"\nMember Discount : "+discount+"%\n\nGrand Total : RM "+x.format(grandtotal)+"\n\nTQ For Shopping With Us","Ecgmr",JOptionPane.PLAIN_MESSAGE);
            }else{
                grandtotal = grandtotal + totalprice - (totalprice * discount/100);
                JOptionPane.showMessageDialog(null,"Product :\n"+productchosen+"\nTotal Price : RM "+x.format(totalprice)+"\nMember Discount : "+discount+"%\n\nGrand Total : RM "+x.format(grandtotal)+"\n\nTQ For Shopping With Us","Ecgmr",JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            do{
                services = (String)JOptionPane.showInputDialog(null,"Choose Services","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,servicesCategory,servicesCategory[0]);
                if(services.equals(servicesCategory[0])){
                    category = (String)JOptionPane.showInputDialog(null,"Choose Formatting","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,formatCategory,formatCategory[0]);
                    if(category.equals(formatCategory[0])||category.equals(formatCategory[1])||category.equals(formatCategory[2])){
                        price = 60.00;
                    }else{
                        price = 80.00;
                    }
                    category = "Formatting : "+category;
                }else if(services.equals(servicesCategory[1])){
                    category = (String)JOptionPane.showInputDialog(null,"Choose Data Recovery","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,recoveryCategory,recoveryCategory[0]);
                    if(category.equals(recoveryCategory[0])){
                        price = 50.00;
                    }else if(category.equals(recoveryCategory[1])){
                        price = 120.00;
                    }else{
                        price = 500.00;
                    }
                    category = "Data Recovery : "+category;
                }else if(services.equals(servicesCategory[2])){
                    category = (String)JOptionPane.showInputDialog(null,"Choose Maintenance","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,maintenanceCategory,maintenanceCategory[0]);
                    if(category.equals(maintenanceCategory[0])){
                        price = 50.00;
                    }else if(category.equals(maintenanceCategory[1])){
                        price = 80.00;
                    }else{
                        price = 40.00;
                    }
                        category = "Maintenance : "+category;
                }else if(services.equals(servicesCategory[3])){
                    category = (String)JOptionPane.showInputDialog(null,"Choose Office Utilities","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,utilitiesCategory,utilitiesCategory[0]);
                    if(category.equals(utilitiesCategory[0])||category.equals(utilitiesCategory[3])){
                        price = 1.00;
                    }else if(category.equals(utilitiesCategory[1])){
                        price = 0.30;
                    }else if(category.equals(utilitiesCategory[2])){
                        price = 5.00;
                    }else if(category.equals(utilitiesCategory[4])){
                        price = 0.20;
                    }else{
                        price = 1.50;
                    }
                    category = "Office Utilities : "+category;
                }else{
                    category = (String)JOptionPane.showInputDialog(null,"Choose Data Backup","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,backupCategory,backupCategory[0]);
                    if(category.equals(backupCategory[0])){
                        price = 40.00;
                    }else if(category.equals(backupCategory[1])){
                        price = 60.00;
                    }else{
                        price = 100.00;
                    }
                    category = "Data Backup : "+category;
                    }
                    do{
                        try{
                            input = (String)JOptionPane.showInputDialog(null,"Services Quantity","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity < 0){
                                JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Services = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException NFE){
                                JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Services = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                        }
                    }while(quantity <= 0);
                    total = price * quantity;
                    totalprice = totalprice + total;
                    serviceschosen = serviceschosen + "          - "+category+"          RM "+x.format(price)+" x "+quantity+" = RM "+x.format(total)+"\n";
                    input = (String)JOptionPane.showInputDialog(null,"Do You Want To Use Another Services ?\n\nEnter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                    while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                        input = (String)JOptionPane.showInputDialog(null,"Invalid Input ! Enter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.ERROR_MESSAGE);
                    }
            }while(input.equalsIgnoreCase("y")==y);
            choose = JOptionPane.showConfirmDialog(null,"Do You Want To Proceed With Product ?","Ecgmr",JOptionPane.YES_NO_OPTION);
            if(choose == JOptionPane.YES_OPTION){
                do{
                    product = (String)JOptionPane.showInputDialog(null,"Choose Product","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,productCategory,productCategory[0]);
                    if(product.equals(productCategory[0])){
                        category = (String)JOptionPane.showInputDialog(null,"Choose Accessory","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,accessoryCategory,accessoryCategory[0]);
                        if(category.equals(accessoryCategory[0])){
                            price = 25.00;
                        }else if(category.equals(accessoryCategory[1])){
                            price = 10.00;
                        }else{
                            price = 5.00;
                        }
                        category = "Accessory : "+category;
                    }else if(product.equals(productCategory[1])){
                        category = (String)JOptionPane.showInputDialog(null,"Choose Charger","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,chargerCategory,chargerCategory[0]);
                        if(category.equals(chargerCategory[0])||category.equals(chargerCategory[1])||category.equals(chargerCategory[2])){
                            price = 75.00;
                        }else{
                            price = 95.00;
                        }
                        category = "Charger : "+category;
                    }else if(product.equals(productCategory[2])){
                        category = (String)JOptionPane.showInputDialog(null,"Choose Gadget","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,gadgetCategory,gadgetCategory[0]);
                        if(category.equals(gadgetCategory[0])){
                            price = 15.00;
                        }else if(category.equals(gadgetCategory[1])){
                            price = 35.00;
                        }else{
                            price = 25.00;
                        }
                        category = "Gadget : "+category;
                    }else{
                        category = (String)JOptionPane.showInputDialog(null,"Choose Computer Components for Desktop","Ecgmr",JOptionPane.QUESTION_MESSAGE,null,componentCategory,componentCategory[0]);
                        if(category.equals(componentCategory[0])){
                            price = 280.00;
                        }else if(category.equals(componentCategory[1])){
                            price = 300.00;
                        }else if(category.equals(componentCategory[2])||category.equals(componentCategory[3])){
                            price = 75.00;
                        }else if(category.equals(componentCategory[4])){
                            price = 110.00;
                        }else if(category.equals(componentCategory[5])){
                            price = 120.00;
                        }else if(category.equals(componentCategory[6])){
                            price = 200.00;
                        }else{
                            price = 90.00;
                        }
                        category = "Computer Components for Dekstop : "+category;
                    }
                    do{
                        try{
                            input = (String)JOptionPane.showInputDialog(null,"Product Quantity","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity < 0){
                                JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Product = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException NFE){
                                JOptionPane.showMessageDialog(null,"Invalid Input ! Minimum Product = 1","Ecgmr",JOptionPane.ERROR_MESSAGE);
                        }
                    }while(quantity <= 0);
                    total = price * quantity;
                    totalprice = totalprice + total;
                    productchosen = productchosen + "          - "+category+"          RM "+x.format(price)+" x "+quantity+" = RM "+x.format(total)+"\n";   
                    input = (String)JOptionPane.showInputDialog(null,"Do You Want To Buy Another Product ?\n\nEnter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.QUESTION_MESSAGE);
                    while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                        input = (String)JOptionPane.showInputDialog(null,"Invalid Input ! Enter [Y] for Yes @ [N] for No","Ecgmr",JOptionPane.ERROR_MESSAGE);
                    }
                }while(input.equalsIgnoreCase("y")==y);
                grandtotal = grandtotal + totalprice - (totalprice * discount/100);
                JOptionPane.showMessageDialog(null,"Services :\n"+serviceschosen+"\nProduct : \n"+productchosen+"\n\nTotal Price : RM "+x.format(totalprice)+"\nMember Discount : "+discount+"%\n\nGrand Total : RM "+x.format(grandtotal)+"\n\nTQ For Shopping With Us","Ecgmr",JOptionPane.PLAIN_MESSAGE);
            }else{
                grandtotal = grandtotal + totalprice - (totalprice * discount/100);
                JOptionPane.showMessageDialog(null,"Services :\n"+serviceschosen+"\nTotal Price : RM "+x.format(totalprice)+"\nMember Discount : "+discount+"%\n\nGrand Total : RM "+x.format(grandtotal)+"\n\nTQ For Shopping With Us","Ecgmr",JOptionPane.PLAIN_MESSAGE);
            }
        }   
    }
}