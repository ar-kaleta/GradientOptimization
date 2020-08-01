package optimization.gradient.main;

import optimization.gradient.algorithm.GradientDescent;
import optimization.gradient.problem.booth.BoothFunction;
import optimization.gradient.problem.booth.TwoDimPoint;

public class Main {

    public static void main(String[] args) {
        BoothFunction op = new BoothFunction();
        GradientDescent<TwoDimPoint> algorithm = new GradientDescent<>(op, 0.001, 0.000000000000000001);
        TwoDimPoint bestSolution = algorithm.optimize();
        System.out.println(bestSolution);
    }
}
