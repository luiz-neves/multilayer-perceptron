import java.util.List;

public class TrainingData {
    public List<Double> inputs;
    public String expectedResult;

    public TrainingData(List<Double> inputs, String expectedResult) {
        this.expectedResult = expectedResult;
        this.inputs = inputs;
    }
}
