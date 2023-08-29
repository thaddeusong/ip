package Duke.task;

import Duke.exception.DukeException;
import Duke.exception.EmptyTaskDescException;
import Duke.exception.NoCommandFoundException;

public abstract class Task {
    final private String name;
    private boolean completed = false;

    public static Task Parse(String line)
            throws EmptyTaskDescException, NoCommandFoundException {
        String[] components = line.split(":", 2);
        TaskType taskType = components[0].equals("todo") ? TaskType.TODO
                          : components[0].equals("deadline") ? TaskType.DEADLINE
                          : TaskType.EVENT;
        String content = components[1];
        switch (taskType) {
        case TODO:
            return Todo.ParseContent(content);
        case DEADLINE:
            return Deadline.ParseContent(content);
        case EVENT:
            return Event.ParseContent(content);
        default:
            throw new NoCommandFoundException(taskType.name());
        }
    }

    public enum TaskType {
        TODO,
        DEADLINE,
        EVENT
    }
    protected String insertColonInTime(String time) {
        return time.replaceFirst(" ", ": ");
    }
    public Task(String name) throws EmptyTaskDescException {
        if(name.isBlank()) {
            throw new EmptyTaskDescException("Name cannot be blank.");
        }
        this.name = name;
    }

    public static Task Of(String task, TaskType taskType)
            throws DukeException {
        switch (taskType) {
            case TODO:
                return new Todo(task);
            case DEADLINE:
                return new Deadline(task);
            case EVENT:
                return new Event(task);
            default:
                throw new NoCommandFoundException(taskType.name());
        }
    }
    public void SetCompleted(){
        completed = true;
    }
    public void SetUncompleted(){
        completed = false;
    }
    public String toString() {

        return completed ? "[X] " + name : "[ ] " + name;

    }

    public String toSaveFormat(){
        return name + "|" + completed;
    }
}