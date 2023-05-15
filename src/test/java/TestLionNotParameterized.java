import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestLionNotParameterized {
    @Mock
    Feline felineMock;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test(expected = Exception.class)
    public void testInvalidSexValue() throws Exception {
        Lion lion = new Lion("Неверное значение", felineMock);
    }
}
