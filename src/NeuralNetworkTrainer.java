import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NeuralNetworkTrainer {

    Long seedForRandomNumbers = 1L;
    Double learningRate = 1.0;
    Integer numberOfEpochs = 50;
    Integer numberOfHiddenLayerNeurons = 2;
    NeuralNetwork neuralNetwork;

    public void train(List<TrainingData> trainingData) {
        neuralNetwork = initializeNeuralNetwork(trainingData, numberOfHiddenLayerNeurons);
    }

    private NeuralNetwork initializeNeuralNetwork(List<TrainingData> trainingData, Integer numberOfHiddenLayerNeurons) {
        // The number of neurons in entrance layer is the size of the input
        Integer numberOfEntranceNeurons = trainingData.get(0).inputs.size();
        // The number of neurons in entrance layer is the quantity of expected results possibles
        Integer numberOfExitNeurons = getQuantityOfDistinctExpectedResults(trainingData);

        NeuralNetwork neuralNetwork = new NeuralNetwork(numberOfEntranceNeurons, numberOfHiddenLayerNeurons, numberOfExitNeurons);

        // Initialize weights, including bias, with random numbers between 0 and 1
        neuralNetwork.initializeWeights(this.seedForRandomNumbers);

        return neuralNetwork;
    }

    private Integer getQuantityOfDistinctExpectedResults(List<TrainingData> trainingData) {
        List<String> expectedResults = new ArrayList<>();
        for (TrainingData td : trainingData) {
            expectedResults.add(td.expectedResult);
        }

        HashSet<String> distinctExpectedResults = new HashSet<>(expectedResults);
        return distinctExpectedResults.size();
    }
}
