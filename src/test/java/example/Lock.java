package example;

import com.naoido.sesame4j.SesameClient;
import com.naoido.sesame4j.model.Key;

public class Lock {
    public static void main(String[] args) {
        SesameClient client = new SesameClient(MyKey.API_KEY);
        Key myKey = new Key(MyKey.UUID, MyKey.SECRET_KEY);

        client.toggle(myKey, "sesame4j");

        //client.lock(myKey, "sesame4j")

        //client.unlock(myKey, "sesame4j")
    }
}
