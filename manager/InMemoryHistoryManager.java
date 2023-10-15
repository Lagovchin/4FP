package manager;

import domain.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private final int MAX_COUNT = 10;
    private final List<Task> history = new ArrayList<>();

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public void addTask(Task task) {
        history.add(task);
        if (history.size() > MAX_COUNT) {
            history.remove(0);
        }
    }
}
