package example;

import com.naoido.sesame4j.SesameClient;
import com.naoido.sesame4j.model.Key;
import com.naoido.sesame4j.model.Status;

import java.io.IOException;

public class GetStatus {
    public static void main(String[] args) throws IOException {
        SesameClient client = new SesameClient(MyKey.API_KEY);
        Key myKey = new Key(MyKey.UUID, MyKey.SECRET_KEY);

        Status status = client.getStatus(myKey);

        System.out.println("-------------------------");

        System.out.println("Battery        : " + status.getBatteryPercentage() + "%");
        System.out.println("BatteryVoltage : " + status.getBatteryVoltage() + "V");
        System.out.println("Position       : " + status.getPosition());
        System.out.println("Status         : " + status.getSesameStatus());
        System.out.println("TimeStamp      : " + status.getTimestamp());

        System.out.println("-------------------------");
    }
}
