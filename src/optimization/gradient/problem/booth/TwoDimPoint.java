package optimization.gradient.problem.booth;

import optimization.gradient.problem.Point;

import java.util.concurrent.ThreadLocalRandom;

public class TwoDimPoint implements Point {
    private final Double x1;
    private final Double x2;

    TwoDimPoint(){
        this.x1 = (double) ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        this.x2 = (double) ThreadLocalRandom.current().nextInt(-100, 100 + 1);
    }

    TwoDimPoint(Double x1, Double x2){
        this.x1 = x1;
        this.x2 = x2;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

}