package org.example.balancedwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class BalancedWordsCounter {

    public Integer count(String input) {
        if(!input.matches("[a-zA-Z]*") || input == null) throw new RuntimeException();
        Integer counter = 0;

        List<String> listOfSubstrings = createSubstrings(input);
        for (String str : listOfSubstrings) {
            if(isWordBalanced(str) == true) {
                counter++;
            }
        }

        return counter;
    }

    private List<String> createSubstrings(String input) {
        List<String> listOfSubstrings = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String substring = input.substring(i, j);
                listOfSubstrings.add(substring);
            }
        }

        return listOfSubstrings;
    }

    public boolean isWordBalanced(String input) {
        HashMap<Character, Integer> mapOfCharacters = new HashMap<>();
        Character character = null;
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            character = input.charAt(i);
            if (mapOfCharacters.containsKey(character) == true) {
                counter = mapOfCharacters.get(character);
                mapOfCharacters.put(character, counter + 1);
            } else {
                mapOfCharacters.put(character, 1);
            }
        }

        if (mapOfCharacters.values().stream().distinct().count() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
