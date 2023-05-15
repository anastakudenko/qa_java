import com.example.Feline;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.Spy;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestFeline {

    @Spy
    Feline feline = new Feline();

    @Test
    public void testGetKittensWithArg() {
        int expected = 2;
        int actual = feline.getKittens(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }
    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline felineSpy = spy(new Feline());
        List<String> expectedFood = Arrays.asList("мясо");
        when(felineSpy.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = felineSpy.eatMeat();
        assertEquals(expectedFood, actualFood);
        verify(felineSpy, times(1)).getFood("Хищник");
    }
}

