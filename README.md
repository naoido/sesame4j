# SesameWebApi for Java!! (sesame4j)
> https://doc.candyhouse.co/ja/SesameAPI

![IMG_0734](https://user-images.githubusercontent.com/54303857/174175724-21a1ea6b-d51f-4a5f-b091-38d1b0aaee50.jpg)


## Usage
```java
SesameClient client = new SesameClient(MyKey.API_KEY);
Key myKey = new Key(MyKey.UUID, MyKey.SECRET_KEY);

client.unlock(myKey, "sesame4j");

System.out.println("unlocked the key!")
```
output
```
unlocked the key!
```
