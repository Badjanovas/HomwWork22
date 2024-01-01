package ToDoApp;

import ToDoApp.Family.FamilyMember;
import ToDoApp.Family.Task;
import ToDoApp.GUI.GUI;
import ToDoApp.Repository.ToDoListRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Task washDishes = new Task("Wash Dishes", false);
        Task washFloor = new Task("Wash Floor", false);
        Task cleanBathroom = new Task("Clean Bathroom", false);
        Task hooverRooms = new Task("Hoover Rooms", false);
        Task takeOutTrash = new Task("Take Out Trash", false);
        Task cleanDust = new Task("Clean The Dust", false);
        Task makeDinner = new Task("Make Dinner", false);
        Task laundry = new Task("Do The Laundry", false);

       // List<Task> tasks = new ArrayList<>(List.of(washDishes, washFloor, cleanBathroom, hooverRooms, takeOutTrash, cleanDust, makeDinner, laundry));

        //tasks.forEach(task -> System.out.println("Task: " + task.getTitle() + " task completed: " + task.getCompleted()));


        //FamilyMember notAssigned = new FamilyMember("Not Assigned", new ArrayList<>(tasks));
        FamilyMember dad = new FamilyMember("Dad", new ArrayList<>());
        FamilyMember mom = new FamilyMember("Mom", new ArrayList<>());
        FamilyMember son = new FamilyMember("Son", new ArrayList<>());
        FamilyMember daughter = new FamilyMember("Daughter", new ArrayList<>());
        List<FamilyMember> familyMembers = new ArrayList<>(List.of(dad, mom, son));

        ToDoListRepository toDoListRepository = new ToDoListRepository();

        toDoListRepository.saveAll(familyMembers);
        toDoListRepository.addFamilyMember(daughter);
        toDoListRepository.addTaskToFamilyMember(dad, washDishes);
        toDoListRepository.addTaskToFamilyMember(dad, cleanDust);
        toDoListRepository.addTaskToFamilyMember(dad, washFloor);
        toDoListRepository.addTaskToFamilyMember(mom, cleanBathroom);
        toDoListRepository.addTaskToFamilyMember(mom, hooverRooms);
        toDoListRepository.addTaskToFamilyMember(mom, takeOutTrash);
        toDoListRepository.addTaskToFamilyMember(son, makeDinner);
        toDoListRepository.addTaskToFamilyMember(daughter, laundry);

        toDoListRepository.removeTask(dad, washDishes);
        toDoListRepository.addTaskToFamilyMember(son, washDishes);


        new GUI();

    }
}
