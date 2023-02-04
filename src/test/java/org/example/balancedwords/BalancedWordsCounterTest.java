package org.example.balancedwords;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BalancedWordsCounterTest {

    @Test
    void shouldCountBalancedSubwords() {
        //given
        String input = "aabbabcccba";
        //when
        BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();
        Integer counter = balancedWordsCounter.count(input);
        //then
        assertThat(counter).isEqualTo(28);
    }

    @Test
    void shouldCountBalancedSubwordsWhenInputIsEmptyString() {
        //given
        String input = "";
        //when
        BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();
        Integer counter = balancedWordsCounter.count(input);
        //then
        assertThat(counter).isEqualTo(0);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
        "abababa1"
    })
    void shouldThrowExceptionWhenInputIsNullOrNonAlphabetical(String input) {
        //when
        BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();
        ThrowableAssert.ThrowingCallable callable = () -> balancedWordsCounter.count(input);
        //then
        assertThatThrownBy(callable).isInstanceOf(RuntimeException.class);
    }
}