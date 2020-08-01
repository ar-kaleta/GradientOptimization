package optimization.gradient.problem;

public interface OptimizationProblem {
    APoint selectStartingPoint();
    APoint calculateNextPoint(APoint startingAPoint);
    void calculateFitnessFunction(APoint APoint);
}
