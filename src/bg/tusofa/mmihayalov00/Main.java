package bg.tusofa.mmihayalov00;

import bg.tusofa.mmihayalov00.dto.Line;
import bg.tusofa.mmihayalov00.utils.FileWorker;
import bg.tusofa.mmihayalov00.utils.TextEditor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        while (true) {
            System.out.println("Type the path to a .txt file to edit it:");
            System.out.println("Type exit to finish the program");
            String input;
            try {
                input = bfr.readLine();
            } catch (IOException e) {
                System.out.println("Failed to read...");
                continue;
            }
            if (input.equals("exit")) break;
            if (!input.endsWith(".txt")) {
                System.out.println("You can edit only .txt files");
                continue;
            }
            try {
                final Line[] fileLines = FileWorker.readFile(input);
                editFile(new TextEditor(fileLines));
                FileWorker.writeFile(input, fileLines);
            } catch (FileNotFoundException e) {
                System.out.println("File not found...");
            }
        }
        System.out.println("Goodbye!");
    }

    private static void editFile(TextEditor editor) {
        while (true) {
            printEditHelp();
            try {
                final String input = bfr.readLine();
                System.out.println();

                if (input.equals("exit")) break;
                if (input.equals("print")) {
                    editor.printText();
                    continue;
                }

                String[] inputSplit = input.split("\\s");

                try {
                    if (inputSplit.length == 2)
                        editor.swapLines(Integer.parseInt(inputSplit[0]), Integer.parseInt(inputSplit[1]));

                    else if (inputSplit.length == 4)
                        editor.swapWords(Integer.parseInt(inputSplit[0]), Integer.parseInt(inputSplit[1]),
                                Integer.parseInt(inputSplit[2]), Integer.parseInt(inputSplit[3]));

                    else System.out.println("Invalid input!");

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Input out of bounds!");
                }

            } catch (IOException e) {
                System.out.println("Failed to read!");
            }
        }
    }
    private static void printEditHelp(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println("- Type <first_line_index> <second_line_index> to switch 2 lines");
        System.out.println("- Type <first_line_index> <first_line_word_index> <second_line_index> <second_line_word_index> to switch 2 words");
        System.out.println("- Type print to see the current text");
        System.out.println("- Type exit to save the file");
        System.out.println("-----------------------------------------------------------------");
    }
}