package productsalesapp_q2;

public class ProductSales implements IProductSales {

    int year1Microphone;
    int year1Speakers;
    int year1MixingDesk;
    int year2Microphone;
    int year2Speakers;
    int year2MixingDesk;
    int salesLimit = 500;

    public int GetTotalSales() {
        return year1Microphone + year1Speakers + year1MixingDesk
                + year2Microphone + year2Speakers + year2MixingDesk;
    }

    public int GetSalesOverLimit() {
        int count = 0;
        if (year1Microphone > salesLimit) {
            count++;
        }
        if (year1Speakers > salesLimit) {
            count++;
        }
        if (year1MixingDesk > salesLimit) {
            count++;
        }
        if (year2Microphone > salesLimit) {
            count++;
        }
        if (year2Speakers > salesLimit) {
            count++;
        }
        if (year2MixingDesk > salesLimit) {
            count++;
        }
        return count;
    }

    public int GetSalesUnderLimit() {
        int count = 0;
        if (year1Microphone <= salesLimit) {
            count++;
        }
        if (year1Speakers <= salesLimit) {
            count++;
        }
        if (year1MixingDesk <= salesLimit) {
            count++;
        }
        if (year2Microphone <= salesLimit) {
            count++;
        }
        if (year2Speakers <= salesLimit) {
            count++;
        }
        if (year2MixingDesk <= salesLimit) {
            count++;
        }
        return count;
    }

    public int GetProductsProcessed() {
        return 2;
    }

    public double GetAverageSales() {
        return (double) GetTotalSales() / 6;
    }
}
