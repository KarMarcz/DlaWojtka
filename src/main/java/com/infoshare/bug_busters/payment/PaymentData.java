package com.infoshare.bug_busters.payment;

public class PaymentData {

    private String cardNumber;
    private String expires;
    private String ccv;

    public PaymentData(String cardNumber, String expires, String CCV){

        this.cardNumber=cardNumber;
        this.expires=expires;
        this.ccv=CCV;

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpires() {
        return expires;
    }

    public String getCcv() {
        return ccv;
    }

    @Override
    public String toString() {
        return "ListPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expires='" + expires + '\'' +
                ", CCV='" + ccv + '\'' +
                '}';
    }
}
