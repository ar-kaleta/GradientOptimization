package optimization.gradient.algorithm;
import optimization.gradient.problem.IOptimizationProblem;
import optimization.gradient.problem.Point;

import java.util.List;

public class GradientDescent <T extends Point> {
    private final IOptimizationProblem<T> problem;
    private final Double epsilon;
    private final Double alphaFactor;
    private final List<T> listOfPoints;

    public GradientDescent(IOptimizationProblem<T> problem, Double alphaFactor, Double epsilon, List<T> listOfPoints){
        this.problem = problem;
        this.alphaFactor = alphaFactor;
        this.epsilon = epsilon;
        this.listOfPoints = listOfPoints;
    }

    private boolean stopCondition(T x){
        List<Double> derivatives = problem.calculateDerivativeFitFun(x);
        return Math.abs(derivatives.get(0)) <= this.epsilon && Math.abs(derivatives.get(1)) <= this.epsilon;
    }

    public T optimize(){
        T x = problem.selectStartingPoint();
        listOfPoints.add(x);
        Double alpha = 1.;                                      //!!!!!!!!!!!!!!
        T x1 = problem.calculateNextPoint(x, alpha);

        while(!stopCondition(x)){
            if(problem.calculateFitnessFunction(x1) >= problem.calculateFitnessFunction(x)){
                alpha -= alphaFactor;
            }
            else{
                x = x1;
                listOfPoints.add(x);
            }
            x1 = problem.calculateNextPoint(x, alpha);
        }
        return x;
    }
}
