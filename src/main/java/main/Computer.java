package main;

import computing.Function;
import computing.log.LogFiveBase;
import computing.log.LogThreeBase;
import computing.log.LogTwoBase;
import computing.trig.Cos;
import computing.trig.Sec;

public class Computer extends Function {

    private final Cos cosFunc;
    private final Sec secFunc;
    private final LogThreeBase logThreeBaseFunc;
    private final LogFiveBase logFiveBaseFunc;
    private final LogTwoBase logTwoBaseFunc;

    public Computer(double accuracy, Cos cosFunc, Sec secFunc, LogThreeBase logThreeBaseFunc, LogFiveBase logFiveBaseFunc, LogTwoBase logTwoBaseFunc) {
        super(accuracy);
        this.cosFunc = cosFunc;
        this.secFunc = secFunc;
        this.logThreeBaseFunc = logThreeBaseFunc;
        this.logFiveBaseFunc = logFiveBaseFunc;
        this.logTwoBaseFunc = logTwoBaseFunc;
    }

    @Override
    public double calculate(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= 0) {
            return cosFunc.calculate(x) * secFunc.calculate(x);
        } else {
            return ((Math.pow(((logTwoBaseFunc.calculate(x) / logFiveBaseFunc.calculate(x))/logTwoBaseFunc.calculate(x)), 2) / logFiveBaseFunc.calculate(x)) + (logTwoBaseFunc.calculate(x) / logThreeBaseFunc.calculate(x)));
        }
    }
}
