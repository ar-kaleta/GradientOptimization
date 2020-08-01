package optimization.gradient.algorithm;
import optimization.gradient.problem.Point;
import optimization.gradient.problem.IOptimizationProblem;

import java.util.List;

public class GradientDescent <T extends Point> {
    private final IOptimizationProblem<T> problem;
    private final Double epsilon;
    private final Double alphaFactor;

    public GradientDescent(IOptimizationProblem<T> problem, Double alphaFactor, Double epsilon){
        this.problem = problem;
        this.alphaFactor = alphaFactor;
        this.epsilon = epsilon;
    }

    private boolean stopCondition(T x){
        List<Double> derivatives = problem.calculateDerivativeFitFun(x);
        return Math.abs(derivatives.get(0)) <= this.epsilon && Math.abs(derivatives.get(1)) <= this.epsilon;
    }

    public T optimize(){
        T x = problem.selectStartingPoint();
        Double alpha = 1.;                                      //!!!!!!!!!!!!!!
        T x1 = problem.calculateNextPoint(x, alpha);

        while(!stopCondition(x)){
            if(problem.calculateFitnessFunction(x1) >= problem.calculateFitnessFunction(x)){
                alpha -= alphaFactor;
            }
            else{
                x = x1;
            }
            x1 = problem.calculateNextPoint(x, alpha);
        }
        return x;
    }
}
