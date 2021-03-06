package computing.log;

import computing.Function;

import java.text.DecimalFormat;

public class LogTwoBase extends Function {

    private final static int BASE = 2;

    private final Ln lnFunc;
    private final DecimalFormat df = new DecimalFormat("#.#####");

    public LogTwoBase(double accuracy, Ln lnFunc) {
        super(accuracy);
        this.lnFunc = lnFunc;
    }

    @Override
    public double calculate(double x) {
        if (Double.isNaN(x) || x < 0.0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return Double.parseDouble(df.format(lnFunc.calculate(x) / lnFunc.calculate(BASE)).replace(",", "."));
    }
}
