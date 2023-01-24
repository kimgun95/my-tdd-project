package tyrant;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;

public class TyrantTest {

  @Test
  public void tyrant에put한뒤get하기() throws IOException {
//    Tyrant tyrant = new Tyrant();
//    tyrant.put("key", "value");
//    assertThat(t.get("key"), is("value"));
    new Socket("localhost", 1978);
  }
}
