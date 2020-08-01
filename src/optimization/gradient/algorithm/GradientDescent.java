package optimization.gradient.algorithm;
import optimization.gradient.problem.Point;
import optimization.gradient.problem.IOptimizationProblem;

public class GradientDescent {
    private final IOptimizationProblem<Point> problem;
    private final Double epsilon;
    private final Double alphaFactor;

    public GradientDescent(IOptimizationProblem<Point> problem, Double alphaFactor, Double epsilon){
        this.problem = problem;
        this.alphaFactor = alphaFactor;
        this.epsilon = epsilon;
    }

    private boolean stopCondition(Point x){
        return problem.calculateDerivativeFitFun(x) < this.epsilon;
    }

    public Point optimize(){
        Point x = problem.selectStartingPoint();
        Double alpha = 100.;                                      //!!!!!!!!!!!!!!
        Point x1 = problem.calculateNextPoint(x, alpha);

        while(stopCondition(x)){
            if(problem.calculateFitnessFunction(x1) >= problem.calculateFitnessFunction(x)){
                alpha *= this.alphaFactor;
            }
            else{
                x = x1;
            }
            x1 = problem.calculateNextPoint(x, alpha);
        }
        return x;
    }
}
