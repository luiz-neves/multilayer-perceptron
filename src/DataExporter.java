import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataExporter {

    public static void exportInitialParameters(NeuralNetworkTrainer trainer) {
        File file = new File("initialParameters.txt");
        String text = "Number of entrance neurons: " + trainer.neuralNetwork.numberOfEntranceNeurons + "\n"
                + "Number of hidden neurons: " + trainer.neuralNetwork.numberOfHiddenLayerNeurons + "\n"
                + "Number of exit neurons: " + trainer.neuralNetwork.numberOfExitNeurons + "\n\n"
                + "Initial learning rate: " + trainer.learningRate + "\n"
                + "Number of epochs: " + trainer.numberOfEpochs + "\n"
                + "Seed for random numbers: " + trainer.seedForRandomNumbers;

        write(file, text);
    }

    public static void exportInitialWeights(NeuralNetwork neuralNetwork) {
        exportWeights("initialWeights.txt", neuralNetwork);
    }

    public static void exportFinalWeights(NeuralNetwork neuralNetwork) {
        exportWeights("finalWeights.txt", neuralNetwork);
    }

    private static void exportWeights(String filename, NeuralNetwork neuralNetwork) {
        File file = new File(filename);

        StringBuilder textBuilder = new StringBuilder();
        appendEntranceLayerBias(textBuilder, neuralNetwork);
        appendHiddenLayerBias(textBuilder, neuralNetwork);
        appendEntranceLayerWeights(textBuilder, neuralNetwork);
        appendHiddenLayerWeights(textBuilder, neuralNetwork);

        write(file, textBuilder.toString());
    }

    private static void appendEntranceLayerBias(StringBuilder textBuilder, NeuralNetwork neuralNetwork) {
        textBuilder.append("Bias in entrance layer\n");
        for (int i = 0; i < neuralNetwork.numberOfHiddenLayerNeurons; i++) {
            textBuilder.append(i)
                    .append(": ")
                    .append(neuralNetwork.entranceNeuronsWeight[neuralNetwork.numberOfEntranceNeurons][i])
                    .append("\n");
        }
    }

    private static void appendHiddenLayerBias(StringBuilder textBuilder, NeuralNetwork neuralNetwork) {
        textBuilder.append("\nBias in hidden layer\n");
        for (int i = 0; i < neuralNetwork.numberOfExitNeurons; i++) {
            textBuilder.append(i)
                    .append(": ")
                    .append(neuralNetwork.hiddenNeuronsWeight[neuralNetwork.numberOfHiddenLayerNeurons][i])
                    .append("\n");
        }
    }

    private static void appendEntranceLayerWeights(StringBuilder textBuilder, NeuralNetwork neuralNetwork) {
        textBuilder.append("\nEntrance neurons weights\n");
        for (int i = 0; i < neuralNetwork.numberOfEntranceNeurons; i++) {
            for (int j = 0; j < neuralNetwork.numberOfHiddenLayerNeurons; j++) {
                textBuilder.append(i)
                        .append("~")
                        .append(j)
                        .append(": ")
                        .append(neuralNetwork.entranceNeuronsWeight[i][j])
                        .append("\n");
            }
        }
    }

    private static void appendHiddenLayerWeights(StringBuilder textBuilder, NeuralNetwork neuralNetwork) {
        textBuilder.append("\nHidden neurons weights\n");
        for (int i = 0; i < neuralNetwork.numberOfHiddenLayerNeurons; i++) {
            for (int j = 0; j < neuralNetwork.numberOfExitNeurons; j++) {
                textBuilder.append(i)
                        .append("~")
                        .append(j)
                        .append(": ")
                        .append(neuralNetwork.hiddenNeuronsWeight[i][j])
                        .append("\n");
            }
        }
    }

    private static void write(File file, String text) {
        try {
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            writer.write(text);

            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
