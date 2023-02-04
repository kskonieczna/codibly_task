package org.example.bubblesort;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BubbleSortTest {

    @Test
    void shouldSortListOfIntegers() {
        //given
        List initialNumbers = Arrays.asList(1, 4, 5, 6, 8, 3, 8);
        //when
        BubbleSort bubbleSort = new BubbleSort();
        List sortedNumbers = bubbleSort.sort(initialNumbers);
        //then
        assertThat(sortedNumbers).containsSequence(1, 3, 4, 5, 6, 8, 8);
    }

    @Test
    void shouldSortListWithIntegersAndDoubles() {
        //given
        List initialNumbers = Arrays.asList(-9.3, 0.2, 4, 0.1, 5, 9);
        //when
        BubbleSort bubbleSort = new BubbleSort();
        List sortedNumbers = bubbleSort.sort(initialNumbers);
        //then
        assertThat(sortedNumbers).containsSequence(-9.3, 0.1, 0.2, 4, 5, 9);
    }

    @Test
    void shouldGiveEmptyOutputWhenInputIsEmpty() {
        //given
        List initialNumbers = Arrays.asList();
        //when
        BubbleSort bubbleSort = new BubbleSort();
        List sortedNumbers = bubbleSort.sort(initialNumbers);
        //then
        assertThat(sortedNumbers).containsSequence();
    }

    @Test
    void shouldSortListAndOmitNullValues() {
        //given
        List initialNumbers = Arrays.asList(null, 5.0001);
        //when
        BubbleSort bubbleSort = new BubbleSort();
        List sortedNumbers = bubbleSort.sort(initialNumbers);
        //then
        assertThat(sortedNumbers).containsSequence(5.0001);
    }

    @Test
    void shouldThrowExceptionWhenInputIsNull() {
        //given
        List initialNumbers = null;
        //when
        BubbleSort bubbleSort = new BubbleSort();
        ThrowableAssert.ThrowingCallable callable = () -> bubbleSort.sort(initialNumbers);
        //then
        assertThatThrownBy(callable).isInstanceOf(RuntimeException.class);
    }
}