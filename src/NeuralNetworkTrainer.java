import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NeuralNetworkTrainer {

    Long seedForRandomNumbers;
    Double learningRate;
    Integer numberOfEpochs;
    Integer numberOfHiddenLayerNeurons;
    NeuralNetwork neuralNetwork;
    List<TrainingData> trainingData;

    public NeuralNetworkTrainer(Long seedForRandomNumbers,
                                Double learningRate,
                                Integer numberOfEpochs,
                                Integer numberOfHiddenLayerNeurons) {
        this.seedForRandomNumbers = seedForRandomNumbers;
        this.learningRate = learningRate;
        this.numberOfEpochs = numberOfEpochs;
        this.numberOfHiddenLayerNeurons = numberOfHiddenLayerNeurons;
    }

    public void initializeNeuralNetwork(List<TrainingData> trainingData) {
        this.trainingData = trainingData;

        // The number of neurons in entrance layer is the size of the input
        Integer numberOfEntranceNeurons = trainingData.get(0).inputs.size();
        // The number of neurons in entrance layer is the quantity of expected results possibles
        Integer numberOfExitNeurons = getQuantityOfDistinctExpectedResults(trainingData);

        neuralNetwork = new NeuralNetwork(numberOfEntranceNeurons, numberOfHiddenLayerNeurons, numberOfExitNeurons);

        // Initialize weights, including bias, with random numbers between 0 and 1
        neuralNetwork.initializeWeights(this.seedForRandomNumbers);
    }

    private Integer getQuantityOfDistinctExpectedResults(List<TrainingData> trainingData) {
        List<String> expectedResults = new ArrayList<>();
        for (TrainingData td : trainingData) {
            expectedResults.add(td.expectedResult);
        }

        HashSet<String> distinctExpectedResults = new HashSet<>(expectedResults);
        return distinctExpectedResults.size();
    }

    public void train() {
        for (int i = 0; i < numberOfEpochs; i++) {
            executeEpoch();
        }
    }

    private void executeEpoch() {
        for (TrainingData data : trainingData) {
            neuralNetwork.feedforward(data.inputs);
        }
    }
}
