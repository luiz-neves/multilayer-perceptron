import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataImporter {

    public static List<TrainingData> importFile(String fileName) throws FileNotFoundException {
        File file = new File(getLocalFileURL(fileName));

        List<TrainingData> trainingData = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            TrainingData line = readLine(scanner);
            trainingData.add(line);
        }

        return trainingData;
    }

    private static String getLocalFileURL(String fileName) {
        return DataImporter.class.getResource(fileName).getPath();
    }

    private static TrainingData readLine(Scanner scanner) {
        // Read line from input file and remove unwanted characters
        String line = scanner.nextLine()
                .replaceAll("[^0-9,.A-Z-]", "");

        List<Double> inputs = getAllElementsExceptLast(line);
        String expectedResult = getExpectedInput(line);

        return new TrainingData(inputs, expectedResult);
    }

    private static List<Double> getAllElementsExceptLast(String line) {
        String[] unconvertedNumbers = line.split(",");
        return Arrays.stream(unconvertedNumbers)
                .map(t -> t.replaceAll("\\s+",""))
                .mapToDouble(Double::parseDouble)
                .limit(unconvertedNumbers.length - 1)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    /**
     * @param line
     * @return the last element in line
     */
    private static String getExpectedInput(String line) {
        String[] allInputs = line.split(",");
        return allInputs[allInputs.length - 1];
    }
}
