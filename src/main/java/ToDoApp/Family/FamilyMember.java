package ToDoApp.Family;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.h2.util.Task;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String familyMember;
    private String name;
    private Integer age;
    private WorkEfficiency workEfficiency;

    @OneToMany(mappedBy = "familyMember")
    private List<Task> tasks;

    public FamilyMember(String familyMember, String name, Integer age, WorkEfficiency workEfficiency, List<Task> tasks) {
        this.familyMember = familyMember;
        this.name = name;
        this.age = age;
        this.workEfficiency = workEfficiency;
        this.tasks = tasks;
    }
}
