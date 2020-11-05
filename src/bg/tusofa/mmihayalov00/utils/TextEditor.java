package bg.tusofa.mmihayalov00.utils;

import bg.tusofa.mmihayalov00.dto.Line;

public class TextEditor {
    private final Line[] lines;

    public TextEditor(Line[] lines) {
        this.lines = lines;
    }

    public Line[] getLines() {
        return lines;
    }

    public void swapLines(final int first, final int second) throws IndexOutOfBoundsException {
        Line swap = lines[first];
        lines[first] = lines[second];
        lines[second] = swap;
    }

    public void swapWords(final int firstLine, final int firstWord, final int secondLine, final int secondWord) throws IndexOutOfBoundsException {
        String swap = lines[firstLine].getWords()[firstWord];
        lines[firstLine].getWords()[firstWord] = lines[secondLine].getWords()[secondWord];
        lines[secondLine].getWords()[secondWord] = swap;
    }

    public void printText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            Line line = lines[i];
            sb.append(i).append(". ").append(String.join(" ", line.getWords())).append(" // ").append(line.getWords().length).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
