package duke.exception;

import duke.message.ErrorMessage;

/**
 * An exception that is thrown when a task description is empty.
 */
public class EmptyTaskDescException extends DukeException {
    public EmptyTaskDescException(String message) {
        super(message);
    }

    @Override
    public ErrorMessage generateErrorMessage() {
        return new ErrorMessage("A task description cannot be empty.");
    }
}


