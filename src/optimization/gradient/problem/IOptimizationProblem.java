package optimization.gradient.problem;

import java.util.List;

public interface IOptimizationProblem <T extends Point> {
    T selectStartingPoint();
    T calculateNextPoint(T point, Double alpha);
    Double calculateFitnessFunction(T point);
    List<Double> calculateDerivativeFitFun(T point);
}
