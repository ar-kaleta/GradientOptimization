package optimization.gradient.problem.booth;

import optimization.gradient.problem.IOptimizationProblem;

import java.util.Arrays;
import java.util.List;


public class BoothFunction implements IOptimizationProblem<TwoDimPoint> {
    @Override
    public TwoDimPoint selectStartingPoint() {
        return new TwoDimPoint();
    }

    @Override
    public TwoDimPoint calculateNextPoint(TwoDimPoint point, Double alpha) {
        List<Double> derivatives = this.calculateDerivativeFitFun(point);
        Double x1 = point.getX1() - alpha*derivatives.get(0);
        Double x2 = point.getX2() - alpha*derivatives.get(1);
        return new TwoDimPoint(x1, x2);
    }

    @Override
    public Double calculateFitnessFunction(TwoDimPoint point) {
        Double x1 = point.getX1();
        Double x2 = point.getX2();
        return (Math.pow(x1 + 2 * x2 - 7, 2) + Math.pow(2 * x1 + x2 - 5, 2));
    }

    @Override
    public List<Double> calculateDerivativeFitFun(TwoDimPoint point) {
        Double x1 = point.getX1();
        Double x2 = point.getX2();
        return Arrays.asList(10 * x1 + 8 * x2 - 34, 8 * x1 + 10 * x2 - 38);
    }
}
