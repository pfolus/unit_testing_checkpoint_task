import java.math.BigDecimal;

public class Sale {

    String productName;
    BigDecimal netValue;
    int taxRate;

    public Sale() {
        this.productName = "default name";
        this.netValue = new BigDecimal("1");
        this.taxRate = 23;
    }

    public Sale(String productName, BigDecimal netValue, int taxRate) throws IllegalArgumentException {

        setProductName(productName);
        setNetValue(netValue);
        setTaxRate(taxRate);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) throws IllegalArgumentException {
        if(productName.equals("")) {
            throw new IllegalArgumentException("Empty product name parameter provided!");
        }
        this.productName = productName;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) throws IllegalArgumentException {
        if(netValue.compareTo(new BigDecimal("0")) != 1) {
            throw new IllegalArgumentException("Net Value should be a positive number");
        } else if(getDecimalsNumber(netValue) != 2){
            throw new IllegalArgumentException("Net Value should be formatted with 2 decimal places");
        }
        this.netValue = netValue;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) throws IllegalArgumentException {
        if (taxRate < 0 || taxRate > 100) {
            throw new IllegalArgumentException("Tax rate must be in range <0,100>!");
        }
        this.taxRate = taxRate;
    }

    private int getDecimalsNumber(BigDecimal number) {
        String string = number.stripTrailingZeros().toPlainString();
        int index = string.indexOf(".");

        if (index < 0) {
            return 0;
        } else {
            return string.length() - index - 1;
        }
    }

    public BigDecimal getGrossValue() {

        BigDecimal grossValue;
        BigDecimal tempValue;

        tempValue = this.netValue.multiply(new BigDecimal(this.taxRate));
        grossValue = tempValue.multiply(new BigDecimal("0.01"));

        return grossValue;
    }
}

