package org.codebreakers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StringUtilsTest {
    // Тест для метода проверки на палиндром
    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("lisil"), "Слово 'lisil' является палиндромом");
        assertFalse(StringUtils.isPalindrome("hello"), "Слово 'hello' не является палиндромом");
        assertTrue(StringUtils.isPalindrome("appa"), "Слово 'appa' является палиндромом");
        assertFalse(StringUtils.isPalindrome("apple"), "Слово 'lis' не является палиндромом");
    }

    // Тест для метода генерации перестановок строки
    @Test
    public void testGeneratePermutations() {
        List<String> permutations = StringUtils.generatePermutations("abc");
        assertEquals(6, permutations.size(), "Должно быть 6 перестановок для строки 'abc'");
        assertTrue(permutations.contains("abc"));
        assertTrue(permutations.contains("acb"));
        assertTrue(permutations.contains("bac"));
        assertTrue(permutations.contains("bca"));
        assertTrue(permutations.contains("cab"));
        assertTrue(permutations.contains("cba"));
    }

    // Тест для метода проверки подстроки
    @Test
    public void testContainsSubstring() {
        assertTrue(StringUtils.containsSubstring("hello world", "world"), "'hello world' содержит подстроку 'world'");
        assertFalse(StringUtils.containsSubstring("hello world", "earth"), "'hello world' не содержит подстроку 'earth'");
        assertTrue(StringUtils.containsSubstring("Java programming", "Java"), "'Java programming' содержит подстроку 'Java'");
        assertFalse(StringUtils.containsSubstring("Advanced Java", "Python"), "'Advanced Java' не содержит подстроку 'Python'");
    }

    // Тест для метода нахождения самой длинной подстроки без повторяющихся символов
    @Test
    public void testLongestUniqueSubstring() {
        assertEquals("abc", StringUtils.longestUniqueSubstring("abcabcbb"), "Самая длинная уникальная подстрока 'abcabcbb' — 'abc'");
        assertEquals("b", StringUtils.longestUniqueSubstring("bbbbb"), "Самая длинная уникальная подстрока 'bbbbb' — 'b'");
        assertEquals("wke", StringUtils.longestUniqueSubstring("pwwkew"), "Самая длинная уникальная подстрока 'pwwkew' — 'wke'");
        assertEquals("", StringUtils.longestUniqueSubstring(""), "Пустая строка должна возвращать пустую строку");
    }

    // Тест для метода компрессии строки
    @Test
    public void testCompressString() {
        assertEquals("a2b1c5a3", StringUtils.compressString("aabcccccaaa"), "Компрессия строки 'aabcccccaaa' должна вернуть 'a2b1c5a3'");
        assertEquals("abcdef", StringUtils.compressString("abcdef"), "Компрессия строки 'abcdef' должна вернуть 'abcdef', так как компрессия не уменьшает длину");
        assertEquals("a1b1c1", StringUtils.compressString("abc"), "Компрессия строки 'abc' должна вернуть 'a1b1c1'");
        assertEquals("a4", StringUtils.compressString("aaaa"), "Компрессия строки 'aaaa' должна вернуть 'a4'");
    }

}
