package org.commands;

import org.exception.CalculatorException;
import org.exception.StackSizeException;

import static java.lang.Math.sqrt;

public class CommandSqrt implements Command {

    @Override
    public void execute(Context context, String[] args) throws CalculatorException {

        double a = context.getValue();

        double sqrt = sqrt(a);
        context.pushValue(sqrt);
    }
}
