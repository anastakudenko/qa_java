import com.example.Cat;
import com.example.Feline;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    public final List<String> meat = List.of("мясо");
    @Mock
    Feline felineMock;

    @Before
    public void setup() throws Exception {
        when(felineMock.eatMeat()).thenReturn(meat);
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();
        assertEquals(meat, actualFood);
    }
}