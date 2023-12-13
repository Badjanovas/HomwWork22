package ToDoApp;

import ToDoApp.Family.FamilyMember;
import ToDoApp.Family.WorkEfficiency;
import ToDoApp.Service.FamilyMemberHybernateService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        FamilyMember Dad = new FamilyMember("Dad", "John Doe", 40, WorkEfficiency.HIGH);
        FamilyMember mom = new FamilyMember("Mom", "Jane Doe", 35, WorkEfficiency.MEDIUM);
        FamilyMember child = new FamilyMember("Child", "Sam Doe", 10, WorkEfficiency.SLOW,List<Task> tasks);

        Session session = FamilyMemberHybernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<FamilyMember> familyMembers;
    }
}
