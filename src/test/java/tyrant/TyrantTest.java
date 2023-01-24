package tyrant;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TyrantTest {


  @Test
  public void tyrant에put한뒤get하기() throws IOException {
//    Tyrant tyrant = new Tyrant();
//    tyrant.put("key", "value");
//    assertThat(t.get("key"), is("value"));

    new TyrantMap().put();
  }

  private class TyrantMap {

    public static final int OPERATION_PREFIX = 0xC8;
    public static final int PUT_OPERATION = 0x10;
    private Socket socket;
    private OutputStream writer;
    private InputStream reader;

    public void put() throws IOException {
      String key = "key";
      String value = "value";
      socket = new Socket("localhost", 1978);
      writer = socket.getOutputStream();
      writer.write(OPERATION_PREFIX);
      writer.write(PUT_OPERATION);
      writer.write(0);
      writer.write(0);
      writer.write(0);
      writer.write(3); // 4 byte
      writer.write(0);
      writer.write(0);
      writer.write(0);
      writer.write(5); // 4 byte
      writer.write(key.getBytes());
      writer.write(value.getBytes());
      reader = socket.getInputStream();
      int status = reader.read();
      assertThat(status, is(0));
    }
  }
}
