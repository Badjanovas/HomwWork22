package ToDoApp.Family;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "familyMember_id")
    private FamilyMember familyMember;

    public Task(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}
