package calculategpa;
/**
 *
 * @author Anonymous
 */
public class SubjectInformation {
    
    public String subCode, subName,subGrade;
    public int subMark;
    public double subCreditHour, subGradePoint;
    
    public SubjectInformation( String code, String subjectName, String grade, int mark, double creditHour, double gradePoint){
        this.subCode = code;
        this.subName = subjectName;
        this.subGrade = grade;
        this.subMark = mark;
        this.subCreditHour = creditHour;
        this.subGradePoint = gradePoint;
    }
    
    public SubjectInformation(){}

    public String displaySubjectInformation(){
        
        String resp ="";
        resp += String.format( "%-" + 10 + "s",subCode);
        resp += String.format( "%-" + 15 + "s",subName);
        resp += String.format( "%-" + 15 + "s",subCreditHour);
        resp += String.format( "%-" + 10 + "s",subMark);
        resp += String.format( "%-" + 10 + "s",subGrade);
        resp += String.format( "%-" + 10 + "s",subGradePoint);
        return resp;
    }
}
