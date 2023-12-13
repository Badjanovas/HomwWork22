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
    private String description;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "familyMember_id")
    private FamilyMember familyMember;

    public Task(String title, String description, Boolean completed, FamilyMember familyMember) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.familyMember = familyMember;
    }
}
