package com.infoshare.bug_busters.unit.random;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class RandomDataGeneratorTest {

    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
    String[] checkingEquality = new String[2];

    @Test
    public void CardNumberRandomTestPattern() {
        assertTrue("Its not 16 number", Pattern.matches("\\d{16}", randomDataGenerator.CardNumberRandom()));
    }

    @Test
    public void ExpiresRandomTestPattern() {
        assertTrue(Pattern.matches("\\d{2}/\\d{2}", randomDataGenerator.Expires()));
    }

    @Test
    public void ccvRandomTestPattenr() {
        assertTrue("its not 3 number", Pattern.matches("\\d{3}", randomDataGenerator.RandomCCV()));
    }

    @Test
    public void CardNumberRandomTestIfIsReallyRandom() {

        for (int i = 0; i < checkingEquality.length; i++) {
            checkingEquality[i] = randomDataGenerator.CardNumberRandom();
        }

        Assertions.assertThat(checkingEquality[0]).isNotEqualTo(checkingEquality[1]);

    }

    @Test
    public void ExpiresRandomTestIfIsReallyRandom() {

        for (int i = 0; i < checkingEquality.length; i++) {
            checkingEquality[i] = randomDataGenerator.Expires();
        }

        Assertions.assertThat(checkingEquality[0]).isNotEqualTo(checkingEquality[1]);

    }

    @Test
    public void ccvRandomTestIfIsReallyRandom() {

        for (int i = 0; i < checkingEquality.length; i++) {
            checkingEquality[i] = randomDataGenerator.RandomCCV();
        }

        Assertions.assertThat(checkingEquality[0]).isNotEqualTo(checkingEquality[1]);

    }
}
