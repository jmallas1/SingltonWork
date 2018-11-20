package singlton.work;

public class ThreadSafeCalcTool
{
    private static ThreadSafeCalcTool inst = null;
    private ThreadSafeCalcTool () {}

    public static int totalBMICalcullated=0;
    public static int numberOfCaculations=0;
    enum MeasurementSystem {METRIC, ENGISH};

    public static ThreadSafeCalcTool getInstance()
    {
        synchronized (ThreadSafeCalcTool.class)
        {
            if (inst == null)
            {
                inst = new ThreadSafeCalcTool();
            }
        }

        return inst;
    }

    public static double calcBMI(double height, double weight, MeasurementSystem measurementSystem)
    {
        double bmi = weight / Math.pow(height,2);
        if (measurementSystem == MeasurementSystem.ENGISH)
        {
            bmi *= 703;
        }
        totalBMICalcullated+=bmi;
        numberOfCaculations++;

        return bmi;
    }

    public static double averageBMI()
    {
        return totalBMICalcullated / numberOfCaculations;
    }

}
