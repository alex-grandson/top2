package computing.trig;

import computing.Function;

public class Sec extends Function {
    private final Cos cosFunction;

    public Sec(double accuracy, Cos cosFunction) {
        super(accuracy);
        this.cosFunction = cosFunction;
    }

    public double calculate(double x) {
        if (Math.abs(x + Math.PI) < getAccuracy()) return Double.POSITIVE_INFINITY;

        double sec =  1 / cosFunction.calculate(x);
        return Double.isFinite(sec) ? sec : Double.POSITIVE_INFINITY;
    }

}
