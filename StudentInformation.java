package calculategpa;

public class StudentInformation
{
    public String name, studentID, gender, intake;
    
    public StudentInformation( String name, String studentID, String gender, String intake )
    {
        this.name = name;
        this.studentID = studentID;
        this.gender = gender;
        this.intake = intake;
    }

    public String displayStudentInformation()
    {
        String resp ="";
        resp += String.format( "%-" + (name.length()+5) + "s","NAME");
        resp += String.format( "%-" + (studentID.length()+5) + "s","ID");
        resp += String.format( "%-" + (gender.length()+5) + "s","GENDER");
        resp += String.format( "%-" + (intake.length()+5) + "s","INTAKE");
        resp +="\n";
        resp += String.format( "%-" + (name.length()+5) + "s",name);
        resp += String.format( "%-" + (studentID.length()+5) + "s",studentID);
        resp += String.format( "%-" + (gender.length()+5) + "s",gender);
        resp += String.format( "%-" + (intake.length()+5) + "s",intake);
        return resp;
    }

//    public String toString()
//    {
//        return "StudentInformation{" +
//                "name='" + name + '\'' +
//                ", studentID='" + studentID + '\'' +
//                ", gender='" + gender + '\'' +
//                ", intake='" + intake + '\'' +
//                '}';
//    }
}
