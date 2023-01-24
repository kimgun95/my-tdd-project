package tyrant;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TyrantTest {


  @Test
  public void tyrant에put한뒤get하기() throws IOException {
//    Tyrant tyrant = new Tyrant();
//    tyrant.put("key", "value");
//    assertThat(t.get("key"), is("value"));

    TyrantMap tyrantMap = new TyrantMap();
    tyrantMap.open();
    tyrantMap.put("key", "value");
    assertThat(tyrantMap.get("key"), is("value".getBytes()));

    tyrantMap.close();
  }

  private class TyrantMap {

    public static final int OPERATION_PREFIX = 0xC8;
    public static final int PUT_OPERATION = 0x10;
    public static final int GET_OPERATION = 0x30;
    private Socket socket;
    private DataOutputStream writer;
    private DataInputStream reader;

    public void put(String key, String value) throws IOException {

      writer.write(OPERATION_PREFIX);
      writer.write(PUT_OPERATION);
      writer.writeInt(key.length());
      writer.writeInt(value.length());
      writer.write(key.getBytes());
      writer.write(value.getBytes());
      int status = reader.read();
      assertThat(status, is(0));
    }

    private void open() throws IOException {
      socket = new Socket("localhost", 1978);
      writer = new DataOutputStream(socket.getOutputStream());
      reader = new DataInputStream(socket.getInputStream());
    }

    public void close() throws IOException {
      socket.close();
    }

    public byte[] get(String key) throws IOException {
      writer.write(OPERATION_PREFIX);
      writer.write(GET_OPERATION);
      writer.writeInt(key.length());
      writer.write(key.getBytes());
      int status = reader.read();
      assertThat(status, is(0));
      int length = reader.readInt();
      byte[] results = new byte[length];
      reader.read(results);
      return results;
    }
  }
}
