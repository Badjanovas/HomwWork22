package ToDoApp.Family;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "familyMember",cascade = CascadeType.ALL)
    private List<Task> tasks;

    public FamilyMember(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }


}
