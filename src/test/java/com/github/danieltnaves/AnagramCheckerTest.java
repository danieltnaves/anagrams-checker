package com.github.danieltnaves;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckerTest {

    @Test
    void should_ReturnFalse_When_TheTwoStringsHaveDifferentLength() {
        assertFalse(new AnagramChecker().isAnagram("xxx", "xxxx"));
    }

    @Test
    void should_ReturnFalse_When_TwoStringsArentAnagrams() {
        assertFalse(new AnagramChecker().isAnagram("aba", "abc"));
    }

    @Test
    void should_ReturnTrue_When_TwoStringsAreAnagrams() {
        assertTrue(new AnagramChecker().isAnagram("listen", "silent"));
    }

    @Test
    void should_ReturnTrue_When_TwoStringsAreAnagramsAndHaveDifferentCase() {
        assertTrue(new AnagramChecker().isAnagram("LisTen", "SiLent"));
    }

    @Test
    void should_ReturnAllAnagrams_When_AnagramsTextsAreProvided() {
        //A = "abc", B = "cba", C = "xxx", D = "cab"
        AnagramChecker anagramChecker = new AnagramChecker();
        assertTrue(anagramChecker.isAnagram("abc", "cba")); // f1(A, B) = true
        assertFalse(anagramChecker.isAnagram("abc", "xxx")); // f1(A, C) = false
        assertTrue(anagramChecker.isAnagram("abc", "cab")); //f1(A, D) = true
        assertThat(anagramChecker.getAnagrams("abc"), containsInAnyOrder("cba", "cab")); // f2(A) -> [B,D] = [cba, cab]
        assertThat(anagramChecker.getAnagrams("cba"), containsInAnyOrder("abc", "cab")); // f2(B) -> [B,D] = [abc, cab]
        assertThat(anagramChecker.getAnagrams("xxx"), anyOf(nullValue(), empty())); // f2(C) -> []
    }
}
