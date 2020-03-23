import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<TrainingData> trainingData = DataImporter.importFile("problemOR.csv");

        NeuralNetworkTrainer trainer = new NeuralNetworkTrainer(1L, 1.0, 50, 2);
        trainer.initializeNeuralNetwork(trainingData);

        DataExporter.exportInitialParameters(trainer);
        DataExporter.exportInitialWeights(trainer.neuralNetwork);
    }
}
