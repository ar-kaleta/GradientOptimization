package optimization.gradient.main;

import optimization.gradient.algorithm.GradientDescent;
import optimization.gradient.problem.booth.BoothFunction;
import optimization.gradient.problem.booth.TwoDimPoint;
import optimization.gradient.visualization.Visualization;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BoothFunction op = new BoothFunction();
        List<TwoDimPoint> listOfPoints = new ArrayList<>();
        GradientDescent<TwoDimPoint> algorithm = new GradientDescent<>(op, 0.001, 0.00001, listOfPoints);
        TwoDimPoint bestSolution = algorithm.optimize();
        System.out.println(bestSolution);
        System.out.println(listOfPoints.size());

        Visualization.visualise(op, 50, 100, listOfPoints, 10f);
    }
}
