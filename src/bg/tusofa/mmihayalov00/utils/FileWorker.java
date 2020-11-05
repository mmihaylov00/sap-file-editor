package bg.tusofa.mmihayalov00.utils;

import bg.tusofa.mmihayalov00.dto.Line;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWorker {
    public static Line[] readFile(final String path) throws FileNotFoundException {
        final ArrayList<Line> lines = new ArrayList<>();
        final Scanner fileReader = new Scanner(new File(path));
        while (fileReader.hasNextLine())
            lines.add(new Line(fileReader.nextLine().split("\\s")));

        fileReader.close();
        return lines.toArray(new Line[0]);
    }

    public static void writeFile(final String path, Line[] lines) {
        try {
            final FileWriter writer = new FileWriter(path);
            for (Line line : lines) {
                writer.write(String.join(" ", line.getWords()));
                writer.write(System.lineSeparator());
            }
            writer.close();
            System.out.println("File saved!");
        } catch (IOException e) {
            System.out.println("Failed to save the file...");
        }

    }

}
