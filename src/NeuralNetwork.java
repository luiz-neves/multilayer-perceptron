import java.util.Random;

public class NeuralNetwork {

    public Integer numberOfEntranceNeurons;
    public Integer numberOfHiddenLayerNeurons;
    public Integer numberOfExitNeurons;

    public Double[] neuronsOfEntranceLayer;
    public Double[] neuronsOfHiddenLayer;
    public Double[] neuronsOfExitLayer;

    public Double[][] entranceNeuronsWeight;
    public Double[][] hiddenNeuronsWeight;

    public NeuralNetwork(Integer numberOfEntranceNeurons,
                         Integer numberOfHiddenLayerNeurons,
                         Integer numberOfExitNeurons) {
        this.numberOfEntranceNeurons = numberOfEntranceNeurons;
        this.numberOfHiddenLayerNeurons = numberOfHiddenLayerNeurons;
        this.numberOfExitNeurons = numberOfExitNeurons;

        // We include the bias here
        this.entranceNeuronsWeight = new Double[numberOfEntranceNeurons + 1][numberOfHiddenLayerNeurons];
        this.hiddenNeuronsWeight = new Double[numberOfHiddenLayerNeurons + 1][numberOfExitNeurons];

        this.neuronsOfEntranceLayer = new Double[numberOfEntranceNeurons + 1];
        this.neuronsOfHiddenLayer = new Double[numberOfHiddenLayerNeurons + 1];
        this.neuronsOfExitLayer = new Double[numberOfExitNeurons];

        // Give bias neurons the value 1
        this.neuronsOfEntranceLayer[numberOfEntranceNeurons] = 1.0;
        this.neuronsOfHiddenLayer[numberOfHiddenLayerNeurons] = 1.0;
    }

    public void initializeWeights(Long seed) {
        Random randomGenerator = new Random(seed);

        // Initialize weights for entrance layer
        for (int numberOfEntranceNeurons = 0; numberOfEntranceNeurons <= this.numberOfEntranceNeurons; numberOfEntranceNeurons++) {
            for (int numberOfHiddenLayerNeurons = 0; numberOfHiddenLayerNeurons < this.numberOfHiddenLayerNeurons; numberOfHiddenLayerNeurons++) {
                entranceNeuronsWeight[numberOfEntranceNeurons][numberOfHiddenLayerNeurons] = randomGenerator.nextDouble();
            }
        }

        // Initialize weights for hidden layer
        for (int numberOfHiddenLayerNeurons = 0; numberOfHiddenLayerNeurons <= this.numberOfHiddenLayerNeurons; numberOfHiddenLayerNeurons++) {
            for (int numberOfExitNeurons = 0; numberOfExitNeurons < this.numberOfExitNeurons; numberOfExitNeurons++) {
                hiddenNeuronsWeight[numberOfHiddenLayerNeurons][numberOfExitNeurons] = randomGenerator.nextDouble();
            }
        }
    }

    public void updateBiasInEntranceLayer(Double bias, Integer neuronOfHiddenLayer) {
        entranceNeuronsWeight[numberOfEntranceNeurons + 1][neuronOfHiddenLayer] = bias;
    }

    public void updateBiasInHiddenLayer(Double bias, Integer neuronOfExitLayer) {
        hiddenNeuronsWeight[numberOfHiddenLayerNeurons + 1][neuronOfExitLayer] = bias;
    }
}
