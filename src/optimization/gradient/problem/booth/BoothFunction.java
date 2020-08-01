package optimization.gradient.problem.booth;

import optimization.gradient.problem.IOptimizationProblem;


public class BoothFunction implements IOptimizationProblem<TwoDimPoint> {
    @Override
    public TwoDimPoint selectStartingPoint() {
        return new TwoDimPoint();
    }

    @Override
    public TwoDimPoint calculateNextPoint(TwoDimPoint point, Double alpha) {
        Double x1 = point.getX1() - alpha*this.calculateDerivativeFitFun(point);
        Double x2 = point.getX2() - alpha*this.calculateDerivativeFitFun(point);
        return new TwoDimPoint(x1, x2);
    }

    @Override
    public Double calculateFitnessFunction(TwoDimPoint point) {
        Double x1 = point.getX1();
        Double x2 = point.getX2();
        return (Math.pow(x1 + 2 * x2 - 7, 2) + Math.pow(2 * x1 + x2 - 5, 2));
    }

    @Override
    public Double calculateDerivativeFitFun(TwoDimPoint point) {
        Double x1 = point.getX1();
        Double x2 = point.getX2();
        return Math.sqrt(Math.pow(10*x1 + 8*x2 -34, 2) + Math.pow(8*x1 + 10*x2 -38, 2));
    }
}
