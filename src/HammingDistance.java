import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDistance
{
    
    public void HammingDist() throws IOException {
        String fileName = "Mesonet.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String[] stationId = new String[120];
        

        String lineOfData = br.readLine();

        for(int i = 0; i<stationId.length; i++)
        {

            stationId[i] = lineOfData;
            lineOfData = br.readLine();

        }
        
        br.close();
    }
   
}
