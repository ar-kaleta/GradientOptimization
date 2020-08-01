package optimization.gradient.problem;

public interface IOptimizationProblem {
    IPoint selectStartingPoint();
    IPoint calculateNextPoint(IPoint point, Float alpha);
    Float calculateFitnessFunction(IPoint point);
    Float calculateDerivativeFitFun(IPoint point);
}
