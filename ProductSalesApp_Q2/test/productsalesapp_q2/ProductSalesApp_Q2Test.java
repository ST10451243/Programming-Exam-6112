package productsalesapp_q2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesApp_Q2Test {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales();

        ps.year1Microphone = 600;
        ps.year1Speakers = 300;
        ps.year1MixingDesk = 800;
        ps.year2Microphone = 100;
        ps.year2Speakers = 700;
        ps.year2MixingDesk = 900;

        // Check sales over limit
        int result = ps.GetSalesOverLimit();

        assertEquals(4, result);
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales();

        // Sample sales values
        ps.year1Microphone = 600;
        ps.year1Speakers = 300;
        ps.year1MixingDesk = 800;
        ps.year2Microphone = 100;
        ps.year2Speakers = 700;
        ps.year2MixingDesk = 900;

        // Check sales under limit
        int result = ps.GetSalesUnderLimit();

        assertEquals(2, result);
    }
}
