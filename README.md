# Anagrams Checker 

This program has two features:

1. Check if two strings are anagrams of each other.
2. Based on the inputs provided on 1) the program identifies the anagrams associations. 

Example:

```
AnagramChecker anagramChecker = new AnagramChecker();

anagramChecker.isAnagram("abc", "cba"); //returns true
anagramChecker.isAnagram("abc", "xxx"); //returns false
anagramChecker.isAnagram("abc", "cab"); //returns true

anagramChecker.getAnagrams("abc") //returns ["cba", "cab"]
anagramChecker.getAnagrams("cba") //returns ["abc", "cab"]
anagramChecker.getAnagrams("xxx") //returns []
```

## How to use

There is a command line to use the anagram checker with the following options:

1. Check if two strings are anagrams
2. Get associated anagrams for a given string
3. Reset the results provided on the feature 1.
4. Exit the program

## Testing

Some tests cases were implemented in order to validate the anagram checker behaviour on AnagramCheckerTest. The tests can be executed using Gradle:

```
./gradlew test 
```

## Build

To build the project execute: 
```
./gradlew build 
```

## Requirements

Java 21


