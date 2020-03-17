import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<TrainingData> trainingData = DataImporter.importFile("caracteres-ruido.csv");
        for (TrainingData td : trainingData) {
            System.out.println(td.expectedResult);
            for (Double input : td.inputs) {
                System.out.print(input + " ");
            }
            System.out.println();
        }
    }
}
