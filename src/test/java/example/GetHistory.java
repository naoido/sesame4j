package example;

import com.naoido.sesame4j.SesameClient;
import com.naoido.sesame4j.model.History;
import com.naoido.sesame4j.model.Key;
import com.naoido.sesame4j.model.Type;

import java.io.IOException;
import java.util.List;

public class GetHistory {
    public static void main(String[] args) throws IOException {
        SesameClient client = new SesameClient(MyKey.API_KEY);
        Key myKey = new Key(MyKey.UUID, MyKey.SECRET_KEY);

        List<History> histories = client.getHistory(myKey, 1, 30);

        System.out.println("--------------------");
        for (History history: histories) {
            System.out.println(Type.getDescription(history.getType()));
            System.out.println(history.getHistoryTag());
            System.out.println(history.getTimeStamp());

            System.out.println("--------------------");
        }
    }
}
