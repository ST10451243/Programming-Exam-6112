package productsalesapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesAppTest {

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        ProductSales sales = new ProductSales();
        int[][] salesData = {
            {100, 200, 300},
            {400, 500, 600}
        };
        int total = sales.TotalSales(salesData);
        assertEquals(2100, total);
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        ProductSales sales = new ProductSales();
        int[][] salesData = {
            {100, 200, 300},
            {400, 500, 600}
        };
        double average = sales.AverageSales(salesData);
        assertEquals(350.0, average);
    }
}
