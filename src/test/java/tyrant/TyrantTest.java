package tyrant;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;

public class TyrantTest {

  @Test
  public void nothing() throws IOException {
    new Socket("localhost", 1978);
  }
}
