package com.infoshare.bug_busters.unit.payment;

import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.payment.PaymentDataGenerator;
import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentDataGeneratorTest {
    PaymentDataGenerator paymentGeneratorApp = new PaymentDataGenerator();

    @Test
    public void preparePaymentsAndPatternMatchTest() {

        PaymentData checkingValuesNotNull = paymentGeneratorApp.preparePayments();

        assertNotNull("Card number is null", checkingValuesNotNull.getCardNumber());
        assertNotNull("Expires is null", checkingValuesNotNull.getExpires());
        assertNotNull("CCV is null", checkingValuesNotNull.getCcv());

        assertTrue("Its not 16 number", Pattern.matches("\\d{16}", checkingValuesNotNull.getCardNumber()));
        assertTrue(Pattern.matches("\\d{2}/\\d{2}", checkingValuesNotNull.getExpires()));
        assertTrue("its not 3 number", Pattern.matches("\\d{3}", checkingValuesNotNull.getCcv()));

    }

    @Test
    public void saveToCollectionTest() {

        int sizeTest = paymentGeneratorApp.safeToCollection().size();
        List<PaymentData> checkingTenValuesNotNullAndCorrectToPattern = paymentGeneratorApp.safeToCollection();

        assertEquals("Wielkość listy nie wynosi 10", 10, sizeTest);

        for (int i = 0; i < sizeTest; i++) {

            assertTrue("Its not 16 number", Pattern.matches("\\d{16}", checkingTenValuesNotNullAndCorrectToPattern.get(i).getCardNumber()));
            assertTrue("Expires is not save in Collection", Pattern.matches("\\d{2}/\\d{2}", checkingTenValuesNotNullAndCorrectToPattern.get(i).getExpires()));
            assertTrue("CCV is not save in Collection", Pattern.matches("\\d{3}", checkingTenValuesNotNullAndCorrectToPattern.get(i).getCcv()));

        }
    }
}
