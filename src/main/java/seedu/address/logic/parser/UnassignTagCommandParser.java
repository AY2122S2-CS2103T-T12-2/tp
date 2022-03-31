package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UnassignTagCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new UnassignTagCommand object
 */
public class UnassignTagCommandParser implements Parser<UnassignTagCommand>,
        DetailedViewExecutableParser<UnassignTagCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UnassignTagCommand
     * and returns a UnassignTagCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnassignTagCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnassignTagCommand.MESSAGE_USAGE));
        }

        String[] inputs = trimmedArgs.split("\\s+");
        if (inputs.length <= 1) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UnassignTagCommand.MESSAGE_USAGE));
        }

        try {
            Index index = ParserUtil.parseIndex(inputs[0]);
            String tagName = inputs[1];
            return new UnassignTagCommand(index, tagName);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnassignTagCommand.MESSAGE_USAGE), pe);
        }
    }

    @Override
    public UnassignTagCommand parseInDetailedViewContext(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnassignTagCommand.MESSAGE_USAGE));
        }

        return new UnassignTagCommand(trimmedArgs);
    }
}