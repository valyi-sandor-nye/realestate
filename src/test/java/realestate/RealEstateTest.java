package realestate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RealEstateTest {

    RealEstate underTest;

    @BeforeEach
    void setup() {
        underTest = new RealEstate("Nyíregyháza",
                500000.0, 40, 2,
                Genre.CONDOMINIUM);
    }

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }

    @Test
    void testMakeDiscountShouldReturnCorrectValue() {
        underTest.makeDiscount(10);
        double actual = underTest.price;
        double expected = 450000.0;
        assertEquals(expected,actual,"makeDiscount miscalculates something");
    }

}
