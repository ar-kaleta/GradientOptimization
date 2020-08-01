package optimization.gradient.algorithm;
import optimization.gradient.problem.IPoint;
import optimization.gradient.problem.IOptimizationProblem;

public class GradientDescent {
    private final IOptimizationProblem problem;
    private final Float epsilon;
    private final Float alphaFactor;

    public GradientDescent(IOptimizationProblem problem, Float alphaFactor, Float epsilon){
        this.problem = problem;
        this.alphaFactor = alphaFactor;
        this.epsilon = epsilon;
    }

    private boolean stopCondition(IPoint x){
        return problem.calculateDerivativeFitFun(x) < this.epsilon;
    }

    public IPoint optimize(){
        IPoint x = problem.selectStartingPoint();
        Float alpha = 100f;                                      //!!!!!!!!!!!!!!
        IPoint x1 = problem.calculateNextPoint(x, alpha);

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
