package com.github.danieltnaves;

import java.util.*;

public class AnagramChecker {

    private Map<String, Set<String>> anagramsMapper;

    public AnagramChecker() {
        this.anagramsMapper = new LinkedHashMap<>();
    }

    public boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        HashMap<Character, Integer> characterFrequency = new HashMap<>();

        for (char character : first.toLowerCase().toCharArray()) {
            characterFrequency.put(character, characterFrequency.getOrDefault(character, 0) + 1);
        }

        for (char character : second.toLowerCase().toCharArray()) {
            characterFrequency.put(character, characterFrequency.getOrDefault(character, 0) - 1);
        }

        if (characterFrequency.values().stream().anyMatch(count -> count > 0)) {
            return false;
        }

        addAnagramResultToAnagramsMapper(first, second);

        return true;
    }

    private void addAnagramResultToAnagramsMapper(String first, String second) {
        anagramsMapper.computeIfAbsent(first, k -> new HashSet<>()).add(second);
        anagramsMapper.computeIfAbsent(second, k -> new HashSet<>()).add(first);
    }

    public Set<String> getAnagrams(String key) {
        Set<String> anagrams = anagramsMapper.getOrDefault(key, new HashSet<>());
        Set<String> result = new HashSet<>(anagrams);
        anagrams.forEach(anagram -> result.addAll(anagramsMapper.get(anagram)));
        result.remove(key);
        return result;
    }

    public void reset() {
        anagramsMapper = new LinkedHashMap<>();
    }

}
