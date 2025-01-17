package duke.exception;

import duke.message.ErrorMessage;

/**
 * An exception that is thrown when a time format is invalid.
 */
public class InvalidTimeFormatException extends DukeException {
    public InvalidTimeFormatException(String message) {
        super(message);
    }

    @Override
    public ErrorMessage generateErrorMessage() {
        return new ErrorMessage(getMessage() + " isn't the right time format.");
    }
}
