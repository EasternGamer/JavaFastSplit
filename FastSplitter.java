package io.github.easterngamer;

public class FastSplitter {
    public static String[] fastSplit(final String content, final String splitter) {
        // Add provision for when the splitter is essentially nothing, i.e., split on every character.
        if (splitter.isEmpty()) {
            final int contentLength = content.length();
            final String[] splits = new String[contentLength];
            for (int i = 0; i < contentLength;) {
                splits[i] = content.substring(i, ++i);
            }
            return splits;
        }

        // Main splitting code
        final int splitterLength = splitter.length();
        String[] splitContent = new String[16];
        int sizeOfSplitContent = 0;
        int maxSize = splitContent.length;
        int indexOfSplitter = content.indexOf(splitter);
        int previousIndex = 0;
        while (indexOfSplitter != -1) {
            if (sizeOfSplitContent == maxSize) {
                final String[] newSplitContent = new String[maxSize <<= 1];
                System.arraycopy(splitContent, 0, newSplitContent, 0, sizeOfSplitContent);
                splitContent = newSplitContent;
            }
            final String temp = content.substring(previousIndex, indexOfSplitter);
            if (!temp.isEmpty()) {
                splitContent[sizeOfSplitContent++] = temp;
            }

            previousIndex = indexOfSplitter + splitterLength;
            indexOfSplitter = content.indexOf(splitter, previousIndex);
        }

        // Build final String array to match the exact size of the number of splits.
        final String temp = content.substring(previousIndex);
        final String[] finalSplitContent;
        if (!temp.isEmpty()) {
            finalSplitContent = new String[sizeOfSplitContent+1];
            finalSplitContent[sizeOfSplitContent] = temp;
        } else {
            finalSplitContent = new String[sizeOfSplitContent];
        }
        System.arraycopy(splitContent, 0, finalSplitContent, 0, sizeOfSplitContent);
        return finalSplitContent;
    }
}
