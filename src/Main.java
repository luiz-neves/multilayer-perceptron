import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<TrainingData> trainingData = DataImporter.importFile("problemOR.csv");

        NeuralNetworkTrainer trainer = new NeuralNetworkTrainer(1L, 1.0, 50, 2);
        trainer.initializeNeuralNetwork(trainingData);

        DataExporter.exportInitialParameters(trainer);
        DataExporter.exportInitialWeights(trainer.neuralNetwork);

        trainer.train();

        NeuralNetwork neuralNetwork = trainer.neuralNetwork;
        System.out.println("Entrance layer");
        for (int i = 0; i < neuralNetwork.numberOfEntranceNeurons; i++) {
            System.out.println(i + ": " + neuralNetwork.neuronsOfEntranceLayer[i]);
        }

        System.out.println("Hidden layer");
        for (int i = 0; i < neuralNetwork.numberOfHiddenLayerNeurons; i++) {
            System.out.println(i + ": " + neuralNetwork.neuronsOfHiddenLayer[i]);
        }

        System.out.println("Exit layer");
        for (int i = 0; i < neuralNetwork.numberOfExitNeurons; i++) {
            System.out.println(i + ": " + neuralNetwork.neuronsOfExitLayer[i]);
        }
    }
}
