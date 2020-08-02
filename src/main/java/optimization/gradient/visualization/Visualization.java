package optimization.gradient.visualization;

import optimization.gradient.problem.IOptimizationProblem;
import optimization.gradient.problem.booth.TwoDimPoint;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.util.List;


public class Visualization extends AbstractAnalysis {
    private final IOptimizationProblem<TwoDimPoint> problem_;
    Range range_;
    int steps_;
    List<TwoDimPoint> points_;
    float pointScale_;

    public Visualization(IOptimizationProblem<TwoDimPoint> problem, int range, int steps, List<TwoDimPoint> points, float pointScale){
        this.problem_ = problem;
        this.range_ = new Range(-range, range);
        this.steps_ = steps;
        this.points_ = points;
        this.pointScale_ = pointScale;
    }

    public static void visualise(IOptimizationProblem<TwoDimPoint> problem, int range, int steps, List<TwoDimPoint> points, float pointScale) throws Exception {
        AnalysisLauncher.open(new Visualization(problem, range, steps, points, pointScale));
    }


    @Override
    public void init() {
        // Define a function to plot
        Mapper mapper = new Mapper() {

            @Override
            public double f(double x, double y) {
                return problem_.calculateFitnessFunction(new TwoDimPoint(x, y));
            }
        };

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range_, steps_, range_, steps_), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);


        // Scatter points

        int size = points_.size();

        Coord3d[] points = new Coord3d[size];
        Color[] colors = new Color[size];
        for (int i=0; i<size; ++i){
            TwoDimPoint elem = points_.get(i);
            points[i] = new Coord3d(elem.getX1(), elem.getX2(), problem_.calculateFitnessFunction(elem));
            float a = 0.25f;
            colors[i] = new Color(0f, 0f, 0f, a);
        }

        Scatter scatter = new Scatter(points, colors, this.pointScale_);

        // Create a chart
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getScene().getGraph().add(surface);
        chart.getScene().add(scatter);
    }
}
