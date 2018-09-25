package com.infoshare.bug_busters.unit.payment;

import com.infoshare.bug_busters.payment.PaymentData;
import org.junit.Test;

import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

public class PaymentDataTest {
    PaymentData listPayment = new PaymentData("0123456789012345", "12/12", "123");


    @Test
    public void cardNumberTest() {
        assertTrue("Card Number have not been saved or it has not 16 digital", Pattern.matches("\\d{16}", listPayment.getCardNumber()));
    }


    @Test
    public void expieresTest() {
        assertTrue("Expires have not been saved or it has not MM/YY pattern", Pattern.matches("\\d{2}/\\d{2}", listPayment.getExpires()));
    }

    @Test
    public void ccvTest() {
        assertTrue("CCV have not been saved or it has not 3 digital", Pattern.matches("\\d{3}", listPayment.getCcv()));
    }
}
