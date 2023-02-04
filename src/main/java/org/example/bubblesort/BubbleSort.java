package org.example.bubblesort;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class BubbleSort {

    public List<Comparable> sort(List<Comparable> initialInput) {
        if (initialInput == null) throw new RuntimeException();
        List<Comparable> input = initialInput.stream().filter(Objects::nonNull).collect(Collectors.toList());

        int n = input.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (convertNumber(input.get(j)).compareTo(convertNumber(input.get(j + 1))) > 0) {
                    var temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }
        return input;
    }

    private BigDecimal convertNumber (Comparable number) {
        BigDecimal result = null;
        if (number instanceof Integer) {
            result = BigDecimal.valueOf(((Integer) number).intValue());
        }
        if (number instanceof Double) {
            result = BigDecimal.valueOf(((Double) number).doubleValue());
        }
        return result;
    }
}
