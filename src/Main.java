import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<TrainingData> trainingData = DataImporter.importFile("problemAND.csv");
        NeuralNetworkTrainer trainer = new NeuralNetworkTrainer();
        trainer.train(trainingData);

        System.out.println("Number of entrance neurons: " + trainer.neuralNetwork.numberOfEntranceNeurons);
        System.out.println("Number of hidden neurons: " + trainer.neuralNetwork.numberOfHiddenLayerNeurons);
        System.out.println("Number of exit neurons: " + trainer.neuralNetwork.numberOfExitNeurons);
        System.out.println();

        System.out.println("Initial learning rate: " + trainer.learningRate);
        System.out.println("Number of epochs: " + trainer.numberOfEpochs);
        System.out.println("Seed for random numbers: " + trainer.seedForRandomNumbers);
        System.out.println();

        System.out.println("Bias in entrance layer");
        for (int i = 0; i < trainer.neuralNetwork.numberOfHiddenLayerNeurons; i++) {
            System.out.println(i + ": " + trainer.neuralNetwork.entranceNeuronsWeight[trainer.neuralNetwork.numberOfEntranceNeurons][i]);
        }
        System.out.println();

        System.out.println("Bias in hidden layer");
        for (int i = 0; i < trainer.neuralNetwork.numberOfExitNeurons; i++) {
            System.out.println(i + ": " + trainer.neuralNetwork.hiddenNeuronsWeight[trainer.neuralNetwork.numberOfExitNeurons][i]);
        }
        System.out.println();

        System.out.println("Entrance neurons weights");
        for (int i = 0; i < trainer.neuralNetwork.numberOfEntranceNeurons; i++) {
            for (int j = 0; j < trainer.neuralNetwork.numberOfHiddenLayerNeurons; j++) {
                System.out.println(i + "~" + j + ": " + trainer.neuralNetwork.entranceNeuronsWeight[i][j]);
            }
        }
        System.out.println();

        System.out.println("Hidden neurons weights");
        for (int i = 0; i < trainer.neuralNetwork.numberOfHiddenLayerNeurons; i++) {
            for (int j = 0; j < trainer.neuralNetwork.numberOfExitNeurons; j++) {
                System.out.println(i + "~" + j + ": " + trainer.neuralNetwork.hiddenNeuronsWeight[i][j]);
            }
        }
    }
}
