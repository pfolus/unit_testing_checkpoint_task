import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sale {

    private String productName;
    private BigDecimal netValue;
    private int taxRate;

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

    public BigDecimal getGrossValue() {

        BigDecimal grossValue;
        BigDecimal taxValue;
        BigDecimal tempValue;

        tempValue = this.netValue.multiply(new BigDecimal(this.taxRate));
        taxValue = tempValue.multiply(new BigDecimal("0.01"));
        grossValue = this.netValue.add(taxValue);
        grossValue = grossValue.setScale(2, RoundingMode.CEILING);

        return grossValue;
    }
}

