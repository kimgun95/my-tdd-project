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

    Socket s = new Socket("localhost", 1978);
    OutputStream writer = s.getOutputStream();
    writer.write(0xC8); // operation prefix
    writer.write(0x10); // put operation
    writer.write(0);
    writer.write(0);
    writer.write(0);
    writer.write(3); // 4 byte
    writer.write(0);
    writer.write(0);
    writer.write(0);
    writer.write(5); // 4 byte
    writer.write(new byte [] {'k', 'e', 'y'}); // key
    writer.write(new byte [] {'v', 'a', 'l', 'u', 'e'}); // value
    InputStream reader = s.getInputStream();
    int status = reader.read();
    assertThat(status, is(0));
  }
}
