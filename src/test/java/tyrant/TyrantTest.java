package tyrant;

import org.junit.jupiter.api.Test;

import java.io.IOException;

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

}
