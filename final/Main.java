import java.io.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int numAlgos = Integer.parseInt(args[0]);
        
        String filesPath = "testFiles/", rdata = "", mdata = "", cdata = "";
        MyBenchmark[] mb = new MyBenchmark[numAlgos];
        File[] files = new File(filesPath).listFiles();
        for (int i = 1; i <= files.length; i++) {
            for (int k = 1; k <= numAlgos; k++) {
                mb[k].benchmark(numAlgos, filesPath + files[i].getName());
                
                rdata = "{\"chart\":{\"caption\":\"Runtime\",\"theme\":\"ocean\"},\"data\":[";
                rdata += mb[k].getRuntime();
                if (k < numAlgos)
                    rdata += ",";
                else
                    rdata += "])";
                
                mdata = "{\"chart\":{\"caption\":\"Memory Usage\",\"theme\":\"ocean\"},\"data\":[";
                mdata += mb[k].getMemoryUsage();
                if (k < numAlgos)
                    mdata += ",";
                else
                    mdata += "])";
                
                cdata = "{\"chart\":{\"caption\":\"CPU Load\",\"theme\":\"ocean\"},\"data\":[";
                cdata += mb[k].getCPULoad();
                if (k < numAlgos)
                    cdata += ",";
                else
                    cdata += "])";
            }
                
            FileWriter f = new FileWriter("runtime" + i + ".json", false);
            PrintWriter p = new PrintWriter(f);

            p.print(rdata);
            p.close();
            
            f = new FileWriter("memoryUsage" + i + ".json", false);
            p = new PrintWriter(f);

            p.print(mdata);
            p.close();

            f = new FileWriter("CPULoad" + i + ".json", false);
            p = new PrintWriter(f);

            p.print(cdata);
            p.close();
        }
    }
}
