package duke.exception;

import duke.message.ErrorMessage;

/**
 * An exception that is thrown when a task index is out of range.
 */
public class TaskIndexOutOfRangeException extends DukeException {
    public TaskIndexOutOfRangeException(String message) {
        super(message);
    }

    @Override
    public ErrorMessage generateErrorMessage() {
        return new ErrorMessage(getMessage() + 1 + " is out of range of the task list.");
    }
}
