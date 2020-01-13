package logic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Locale;

public class FunctionCalculator {
    private double a;
    private double b;
    private double h;
    private double y;
    private double x;
    private String f;
    ScriptEngine engine;

    public FunctionCalculator() {
    }

    public FunctionCalculator(double a, double b, double h, String f) {
        this.a = a;
        this.b = b;
        this.h = h;
        this.f = f;
        engine = new ScriptEngineManager().getEngineByName("nashorn");
        doCalc();
    }

    private double f(double x) {
        Locale.setDefault(Locale.US);
//        return Math.sin(x) + Math.cos(x);

        try {
            engine.put("x", x);
            Double v = (Double) engine.eval(this.f);
            return v;
        } catch (ScriptException e) {
            return Double.NaN;
        }
    }

    private void doCalc() {
        int n = (int)Math.round((b - a) / h + 1);
        double maxy = Double.NEGATIVE_INFINITY;
        double maxx = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < n; i++) {
            double x = a + i * h;
            double y = f(x);
            if (y > maxy) {
                maxy = y;
                maxx = x;
            }
        }
        this.x = maxx;
        this.y = maxy;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
