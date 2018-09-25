package com.infoshare.bug_busters.payment;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import java.util.ArrayList;
import java.util.List;

public class PaymentDataGenerator {

    public PaymentData preparePayments() {

        String CardRandomString = RandomDataGenerator.CardNumberRandom();
        String CardExpiresString = RandomDataGenerator.Expires();
        String randomCCVString = RandomDataGenerator.RandomCCV();

        return new PaymentData(CardRandomString, CardExpiresString, randomCCVString);

    }

    public List<PaymentData> safeToCollection() {

        Integer iloscDanych = 10;

        List<PaymentData> paymentsData = new ArrayList<>();

        for (int i = 1; i <= iloscDanych; i++) {
            paymentsData.add(preparePayments());
        }

        return paymentsData;

    }

}
