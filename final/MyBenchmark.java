import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class MyBenchmark {
    private int tester;
    private String name;
    private long runTime;
    private double memUsed;
    private int processors;
    private double load;
    
    public MyBenchmark() {
    }
    
    public void benchmark(int tester, String dataFile) {
        String[] args = {dataFile};
        
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double beforeLoad = os.getProcessCpuLoad();
        long startTime = System.currentTimeMillis();
        double startMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
       
        for (int k = 0; k < 1000000; k++)
            switch (tester) {
                case 1 : 
                    tester1.main(args);
                    name = tester1.algoName;
                    break;
                case 2 : 
                    tester2.main(args);
                    name = tester2.algoName;
                    break;
                case 3 :
                    tester3.main(args);
                    name = tester3.algoName;
                    break;
                case 4 : 
                    tester4.main(args);
                    name = tester4.algoName;
                    break;
                case 5 : 
                    tester5.main(args);
                    name = tester5.algoName;
                    break;
                case 6 : 
                    tester6.main(args);
                    name = tester6.algoName;
                    break;
                case 7 : 
                    tester7.main(args);
                    name = tester7.algoName;
                    break;
                case 8 : 
                    tester8.main(args);
                    name = tester8.algoName;
                    break;
                case 9 : 
                    tester9.main(args);
                    name = tester9.algoName;
                    break;
                case 10 : 
                    tester10.main(args);
                    name = tester10.algoName;
                    break;
            }
        
        long endTime = System.currentTimeMillis();
        double endMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        double afterLoad = os.getProcessCpuLoad();
        
        runTime = endTime - startTime;
        memUsed = endMem - startMem;
        processors = Runtime.getRuntime().availableProcessors();
        load = afterLoad - beforeLoad;
        
        /*
      
        System.out.println("Thread: " + name);
        System.out.println("======================");
        System.out.println("RunTime: " + runTime + " ms");
        System.out.println("MemoryUsed: " + memUsed + " bytes");
        System.out.println("Available Processors: " + processors);
        System.out.println("CPU Usage: " + load);
        
        System.out.println("\n");
        
        */
    }
    
    public String getRuntime() {
        return "{\"label\":\"" + name + "\",\"value\":\"" + runTime + "\"}";
    }
    
    public String getMemoryUsage() {
        return "{\"label\":\"" + name + "\",\"value\":\"" + memUsed + "\"}";
    }
    
    public String getCPULoad() {
        return "{\"label\":\"" + name + "\",\"value\":\"" + load + "\"}";
    }
}
