import domain.Statuses;
import domain.Task;
import domain.Epic;
import domain.SubTask;
import manager.*;


public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefault();

        Task task1 = new Task("Убраться", "Помыть пол в зале", Statuses.NEW);
        taskManager.addTask(task1);
        Task task2 = new Task("Заняться спортом", "Отжаться 15 раз", Statuses.NEW);
        taskManager.addTask(task2);
        System.out.println(taskManager.getTaskById(task1.getId()));
        System.out.println(taskManager.getHistory());
        System.out.println(taskManager.getTaskById(task2.getId()));
        System.out.println(taskManager.getHistory());
        System.out.println();
        System.out.println();

        Epic epic1 = new Epic("Помочь родителям", "В субботу прийти к родителям и помочь");
        taskManager.addEpic(epic1);
        Epic epic2 = new Epic("Дом", "Помочь по дому");
        taskManager.addEpic(epic2);
        System.out.println(taskManager.getEpicById(epic1.getId()));
        System.out.println(taskManager.getHistory());
        System.out.println(taskManager.getEpicById(epic2.getId()));
        System.out.println(taskManager.getHistory());
        System.out.println();
        System.out.println();

        SubTask subTask1 = new SubTask(epic1.getId(),  "Газон", "Подстричь газон", Statuses.NEW);
        taskManager.addSubTask(subTask1);
        SubTask subTask2 = new SubTask(epic2.getId(),  "Помочь маме", "Полить огород", Statuses.NEW);
        taskManager.addSubTask(subTask2);
        SubTask subTask3 = new SubTask(epic2.getId(), "Сделать  ремонт", "Поменять смеситель", Statuses.DONE);
        taskManager.addSubTask(subTask3);
        System.out.println(taskManager.getSubTaskById(subTask1.getId()));
        System.out.println(taskManager.getHistory());
        System.out.println(taskManager.getSubTaskById(subTask2.getId()));
        System.out.println(taskManager.getHistory());
        System.out.println(taskManager.getSubTaskById(subTask3.getId()));
        System.out.println(taskManager.getHistory());
        System.out.println();
        System.out.println();


        System.out.println(taskManager.getTasks());
        System.out.println(taskManager.getEpics());
        System.out.println(taskManager.getSubTasks());
        System.out.println();
        System.out.println();

        task1.setStatus(Statuses.IN_PROGRESS);
        task2.setStatus(Statuses.IN_PROGRESS);
        subTask1.setStatus(Statuses.NEW);
        subTask2.setStatus(Statuses.IN_PROGRESS);
        subTask3.setStatus(Statuses.DONE);
        taskManager.getTaskById(task1.getId());
        taskManager.getTaskById(task2.getId());
        taskManager.getSubTaskById(subTask1.getId());
        taskManager.getSubTaskById(subTask2.getId());
        taskManager.getSubTaskById(subTask3.getId());
        System.out.println(taskManager.getHistory());


        taskManager.updateTask(task1);
        taskManager.updateTask(task2);
        taskManager.updateSubTask(subTask1);
        taskManager.updateSubTask(subTask2);
        taskManager.updateSubTask(subTask3);

        taskManager.getTaskById(task1.getId());
        taskManager.getTaskById(task2.getId());
        taskManager.getSubTaskById(subTask1.getId());
        taskManager.getSubTaskById(subTask2.getId());
        taskManager.getSubTaskById(subTask3.getId());
        System.out.println(taskManager.getHistory());


        System.out.println(taskManager.getTasks());
        System.out.println(taskManager.getEpics());
        System.out.println(taskManager.getSubTasks());
        System.out.println();
        System.out.println();
        System.out.println(taskManager.getHistory());

        taskManager.deleteTaskById(task1.getId());
        taskManager.deleteEpicById(epic1.getId());
        taskManager.deleteSubTaskById(subTask2.getId());

        System.out.println(taskManager.getTasks());
        System.out.println(taskManager.getEpics());
        System.out.println(taskManager.getSubTasks());
        System.out.println();
        System.out.println();
        System.out.println(taskManager.getHistory());


    }
}