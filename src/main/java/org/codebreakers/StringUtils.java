package org.codebreakers;

import java.util.*;

public class StringUtils {

    /**
     * Проверяет, является ли строка палиндромом.
     *
     * @param str строка для проверки
     * @return true, если строка является палиндромом, иначе false
     */
    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        StringBuilder reversedStr = new StringBuilder(cleanStr).reverse();
        return cleanStr.contentEquals(reversedStr);
    }

    /**
     * Генерирует все возможные перестановки строки.
     *
     * @param str строка, для которой необходимо сгенерировать перестановки
     * @return список всех перестановок строки
     */
    public static List<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permute("", str, permutations);
        return permutations;
    }

    /**
     * Вспомогательный рекурсивный метод для генерации перестановок.
     *
     * @param prefix текущий префикс (собранная часть строки)
     * @param str оставшаяся часть строки для перестановки
     * @param permutations список для сохранения всех перестановок
     */
    private static void permute(String prefix, String str, List<String> permutations) {
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutations);
            }
        }
    }

    /**
     * Проверяет, содержит ли строка указанную подстроку.
     *
     * @param str строка, в которой выполняется поиск
     * @param substring подстрока для поиска
     * @return true, если строка содержит подстроку, иначе false
     */
    public static boolean containsSubstring(String str, String substring) {
        return str.contains(substring);
    }

    /**
     * Находит самую длинную подстроку без повторяющихся символов.
     *
     * @param str исходная строка
     * @return самая длинная подстрока без повторяющихся символов
     */
    public static String longestUniqueSubstring(String str) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        String longestSubstring = "";
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (charIndexMap.containsKey(c)) {
                start = Math.max(start, charIndexMap.get(c) + 1);
            }

            charIndexMap.put(c, i);

            if (i - start + 1 > longestSubstring.length()) {
                longestSubstring = str.substring(start, i + 1);
            }
        }

        return longestSubstring;
    }

    /**
     * Выполняет компрессию строки с помощью подсчета повторяющихся символов.
     * Например, "aabcccccaaa" преобразуется в "a2b1c5a3".
     * В этом методе допущена ошибка, которая приводит к некорректному результату.
     *
     * @param str исходная строка для компрессии
     * @return сжатая строка, либо исходная строка, если сжатие не уменьшает длину
     */
    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        // Ошибка: изначальное значение count должно быть 1, а не 2.
        int count = 2; // Некорректное значение

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1)).append(count);
                // Ошибка: после обновления count нужно сбрасывать его значение на 1.
                count = 2; // Некорректное значение
            }
        }
        compressed.append(str.charAt(str.length() - 1)).append(count);

        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
