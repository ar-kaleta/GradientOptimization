package optimization.gradient.problem;

public interface IOptimizationProblem <T extends Point> {
    T selectStartingPoint();
    T calculateNextPoint(T point, Double alpha);
    Double calculateFitnessFunction(T point);
    Double calculateDerivativeFitFun(T point);
}
