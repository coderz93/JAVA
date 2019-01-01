package calculategpa;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class CalculateGPA{
    public static final String STRING_REGEX = "[a-zA-Z\\s]+";
    
    public static void main(String[] args){
        JDialog.setDefaultLookAndFeelDecorated(true);
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");
        
        System.out.println("------------------------------ STUDENT GRADING SYSTEM ------------------------------\n");
        System.out.println("STUDENT INFORMATION");
        
        String intake;
        int numberOfStudents = 0;
        
        do{
            System.out.print("Intake : ");
            intake = input.nextLine();
            if("".equals(intake)){
                JOptionPane.showMessageDialog(null,"Required data for student intake ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
            }
        }while("".equals(intake));
        
        do{
            try{
                System.out.print ("Number of student : ");
                String numberOfStudentString = input.nextLine();
            
                if("".equals(numberOfStudentString)){
                    JOptionPane.showMessageDialog(null,"Required data for number of student : ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                } else{
                    numberOfStudents = Integer.parseInt(numberOfStudentString);
                    if(!(numberOfStudents >=1)){
                        JOptionPane.showMessageDialog(null,"Number of student should be atleast 1 person ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"              Integer only ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
            }
        }while(!(numberOfStudents >=1));
        
        for ( int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
            String name = "", studentID, gender;
            int numberOfSubject = 0;
            double GPA = 0;
            
            do{
                System.out.print ("\nName : ");
                name = input.nextLine();
                if("".equals(name)){
                    JOptionPane.showMessageDialog(null,"Required data for student name ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                    continue; 
                }
                if(!name.matches(STRING_REGEX)){
                    JOptionPane.showMessageDialog(null,"          Character only ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                }
            }while(!name.matches(STRING_REGEX));
        
            do{
                System.out.print("Gender : "); //( Enter M @ m for Male or F @ f for Female )
                gender = input.nextLine();
                if("".equals(gender)){
                    JOptionPane.showMessageDialog(null,"Required data for student gender ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                if(!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f")){
                    JOptionPane.showMessageDialog(null,"          M or m for Male\n          F or f for Female ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                }
            }while(!gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("f"));
            gender = gender.toLowerCase().equals("m") ? "Male" : "Female";
            
            do{
                System.out.print("ID : ");
                studentID = input.nextLine();
                if("".equals(studentID)){
                    JOptionPane.showMessageDialog(null,"Required data for student ID ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                }
            }while("".equals(studentID));
               
            StudentInformation studentInfo = new StudentInformation (name, studentID, gender, intake);
            System.out.println("\nSUBJECT DETAILS");
            do{
                try{
                    
                    System.out.print("Number of subject taken ( Range 1 - 10 ) : ");
                    String numberOfSubjectString = input.nextLine(); //numberOfSubject = Integer.parseInt(input.nextLine());
                
                    if("".equals(numberOfSubjectString)){
                        JOptionPane.showMessageDialog(null,"Required data for number of subject taken ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                    } else{
                        numberOfSubject = Integer.parseInt(numberOfSubjectString);
                        
                        if(!(numberOfSubject >= 1 && numberOfSubject <= 10)){
                            JOptionPane.showMessageDialog(null,"Number of subject has to be 1 to 10 ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch(NumberFormatException e){
                //    System.out.println(e.getMessage()); // only developer can see the error message
                    JOptionPane.showMessageDialog(null,"              Integer only ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                }
            }while(!(numberOfSubject >= 1 && numberOfSubject <= 10));
        
            SubjectInformation[] subjectList = new SubjectInformation[numberOfSubject];
        
            for(numberOfSubject = 0; numberOfSubject < subjectList.length;numberOfSubject++){
                String code, subjectName = "", grade = "";
                int mark = 0;
                double gradePoint = 0, totalGradePoint = 0, creditHour = 0,totalCreditHour = 0;
            
                while(!subjectName.matches(STRING_REGEX)){
                    System.out.print("\nSubject Name : ");
                    subjectName = input.nextLine();
                    if("".equals(subjectName)){
                        JOptionPane.showMessageDialog(null,"Required data for subject name ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                        continue;
                    }
                    if(!subjectName.matches(STRING_REGEX)){
                        JOptionPane.showMessageDialog(null,"          Character only ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                    }
                }
            
                do{
                    System.out.print("Code : ");
                    code = input.nextLine();
                    if("".equals(code)){
                        JOptionPane.showMessageDialog(null,"Required data for subject code ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                    }
                }while("".equals(code));

                do{
                    try{
                        String creditHourString;
                        System.out.print("Credit hour ( Range 1 - 4 ) : ");
                        creditHourString = input.nextLine();
                        if("".equals(creditHourString)){
                            JOptionPane.showMessageDialog(null,"Required data for credit hour ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                        } else{
                            creditHour = Integer.parseInt(creditHourString);
                            if(!(creditHour >= 1 && creditHour <= 4))
                            {
                                JOptionPane.showMessageDialog(null,"Credit hour has to be 1 to 4 ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,"              Integer only ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                    }
                }while(!(creditHour >= 1 && creditHour <= 4));
            
                do{
                    try{                        
                        System.out.print("Mark ( Range 0 - 100 ) : ");
                        String markString = input.nextLine();
                        if("".equals(markString)){
                            JOptionPane.showMessageDialog(null,"Required data for subject mark ","GRADING SYSTEM",JOptionPane.WARNING_MESSAGE);
                            continue;                                  // if we don't want to use the "continue;" code, 
                        } else{
                            mark = Integer.parseInt(markString);                           
                            if(!(mark >= 0 && mark <= 100)){
                                JOptionPane.showMessageDialog(null,"Mark has to be 0 to 100 ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if(mark >= 95 && mark <= 100){
                            grade = "A+"; 
                            gradePoint = 4.0;
                        } else if(mark >= 85 && mark <= 94){
                            grade = "A";
                            gradePoint = 3.75;
                        } else if(mark >= 75 && mark <= 84){
                            grade = "B+";
                            gradePoint = 3.5;
                        } else if(mark >= 65 && mark <= 74){
                            grade = "B";
                            gradePoint = 3.0;
                        } else if(mark >= 55 && mark <= 64){
                            grade = "C+";
                            gradePoint = 2.5;
                        } else if(mark >= 45 && mark <= 54){
                            grade = "C";
                            gradePoint = 2.0;
                        } else if(mark >= 30 && mark <= 44){
                            grade = "D";
                            gradePoint = 1.75;
                        } else {
                            grade = "F";
                            gradePoint = 0.0;
                        }                    
                    } catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"              Integer only ","GRADING SYSTEM",JOptionPane.ERROR_MESSAGE);
                    }
                }while(!(mark >= 0 && mark <= 100));
                
                totalCreditHour = totalCreditHour + creditHour;
                totalGradePoint = totalGradePoint + (gradePoint * creditHour);
                GPA = totalGradePoint / totalCreditHour;
            
                subjectList[numberOfSubject] = new SubjectInformation(code, subjectName, grade, mark, creditHour, gradePoint);
            }
            System.out.println("\n\n------------------------------ RESULT FOR THIS SEMESTER ------------------------------");
            System.out.println("\nSTUDENT INFORMATION\n"+studentInfo.displayStudentInformation()+"\n");
            System.out.println(displayTitleSubjectInformation());
        
            for(numberOfSubject = 0; numberOfSubject < subjectList.length; numberOfSubject++){
                System.out.println(subjectList[numberOfSubject].displaySubjectInformation());   
            }

            System.out.println("\nGPA for this semester : " + df.format(GPA) + "\n");
        }
    }
        //public static void showMessage(String message, int messageType){  
            //JOptionPane.showMessageDialog(null,message,"GRADING SYSTEM",messageType);
        //}
    
        public static String displayTitleSubjectInformation(){
            String resp = "";
            resp += String.format("SUBJECT INFORMATION\n");
            resp += String.format( "%-" + 10 + "s","CODE");
            resp += String.format( "%-" + 15 + "s","NAME");
            resp += String.format( "%-" + 15 + "s","CREDIT HOUR");
            resp += String.format( "%-" + 10 + "s","MARK");
            resp += String.format( "%-" + 10 + "s","GRADE");
            resp += String.format( "%-" + 10 + "s","GRADEPOINT");
            return resp;
        }
}