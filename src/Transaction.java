import java.text.DecimalFormat;

public class Transaction {

    private double amount;
    private int originAccountId;
    private int resultingAccountId;
    private String purposeOfTransaction;


    public Transaction(double amount, int originAccountId, int resultingAccountId, String purposeOfTransaction) {
        this.amount = amount;
        this.originAccountId = originAccountId;
        this.resultingAccountId = resultingAccountId;
        this.purposeOfTransaction = purposeOfTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOriginAccountId() {
        return originAccountId;
    }

    public void setOriginAccountId(int originAccountId) {
        this.originAccountId = originAccountId;
    }

    public int getResultingAccountId() {
        return resultingAccountId;
    }

    public void setResultingAccountId(int resultingAccountId) {
        this.resultingAccountId = resultingAccountId;
    }

    public String getPurposeOfTransaction() {
        return purposeOfTransaction;
    }

    public void setPurposeOfTransaction(String purposeOfTransaction) {
        this.purposeOfTransaction = purposeOfTransaction;
    }

    @Override
    public String toString() {
        return
                "\tAmount -> " + Main.decfor.format(amount) + "\n" +
                        "\t\tOrigin Account id ->" + originAccountId + "\n" +
                        "\t\tResulting Account id -> " + resultingAccountId + "\n" +
                        "\t\tReason -> '" + purposeOfTransaction + '\'' +
                        '}' + "\n" + "**************************";
    }
}
