package org.main;

import org.calculator.CommandFactory;
import org.calculator.RunCalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        InputStream input = System.in;
        if (args.length > 0) {
            input = new FileInputStream(args[0]);
        }

        RunCalculator calculator = null;

        try {
            calculator = new RunCalculator();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        Scanner scan = new Scanner(input);

        while (scan.hasNextLine()) {
            try {
                calculator.parseAndExecute(scan.nextLine());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
