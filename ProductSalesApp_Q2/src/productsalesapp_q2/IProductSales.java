package productsalesapp_q2;

public interface IProductSales {

    int GetTotalSales();

    int GetSalesOverLimit();

    int GetSalesUnderLimit();

    int GetProductsProcessed();

    double GetAverageSales();
}
