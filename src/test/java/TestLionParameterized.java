import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.List;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TestLionParameterized {
    private final String sex;
    private final boolean expectedHasMane;
    @Mock
    Feline felineMock;
    public TestLionParameterized(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Parameters
    public static Object[][] getData() {
        return new Object[][]{{"Самка", false}, {"Самец", true}};
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(lion.doesHaveMane(), expectedHasMane);
    }
    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, felineMock);
        List<String> actualFood = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        Lion lion = new Lion(sex, felineMock);
        int actualKittens = lion.getKittens();
        assertEquals(1, actualKittens);
    }
}