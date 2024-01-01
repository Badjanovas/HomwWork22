package ToDoApp.Repository;

import ToDoApp.Family.FamilyMember;
import ToDoApp.Family.Task;
import ToDoApp.Service.FamilyMemberHibernateService;
import ToDoApp.Service.FamilyMemberService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ToDoListRepository {

    public void saveAll(List<FamilyMember> familyMembers) {
        Session session = FamilyMemberHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        for (FamilyMember familyMember : familyMembers) {
            for (Task task : familyMember.getTasks()) {
                task.setFamilyMember(familyMember);
                session.save(task);
            }
            session.save(familyMember);
        }
        transaction.commit();
        session.close();
        System.out.println("Family list saved to DB successfully.");

    }

    public void addFamilyMember(FamilyMember familyMemberToAdd) {
        Session session = FamilyMemberHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        for (Task task : familyMemberToAdd.getTasks()) {
            task.setFamilyMember(familyMemberToAdd);
            session.save(task);
        }
        session.save(familyMemberToAdd);
        transaction.commit();
        session.close();
        System.out.println(familyMemberToAdd.getName() + " added to DB");
    }

    public void addTaskToFamilyMember(FamilyMember familyMember, Task task) {
        Session session = FamilyMemberHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        familyMember.getTasks().add(task);

        for (Task familyMemberTask : familyMember.getTasks()) {
            familyMemberTask.setFamilyMember(familyMember);
            session.save(task);
        }
        transaction.commit();
        session.close();
        System.out.println(task.getTitle() + " task was added to " + familyMember.getName() + " successfully.");
    }

    public void removeTask(FamilyMember familyMember, Task task){
        Session session = FamilyMemberHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        familyMember.getTasks().remove(task);

        for (Task familyMemberTask : familyMember.getTasks()) {
            familyMemberTask.setFamilyMember(familyMember);
            session.delete(task);
        }
        transaction.commit();
        session.close();
        System.out.println(task.getTitle() + " task was removed from " + familyMember.getName() + " successfully.");
    }


}
