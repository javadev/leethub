import java.util.SortedSet
import java.util.TreeSet

@Suppress("NAME_SHADOWING")
class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        var k = k
        val map: MutableMap<String, Int> = HashMap()
        for (word in words) {
            map[word] = map.getOrDefault(word, 0) + 1
        }
        val sortedset: SortedSet<Map.Entry<String, Int>> = TreeSet(
            java.util.Comparator { (key, value): Map.Entry<String, Int>, (key1, value1): Map.Entry<String, Int> ->
                if (value != value1) {
                    return@Comparator value1 - value
                } else {
                    return@Comparator key.compareTo(key1, ignoreCase = true)
                }
            }
        )
        sortedset.addAll(map.entries)
        val result: MutableList<String> = ArrayList()
        val iterator: Iterator<Map.Entry<String, Int>> = sortedset.iterator()
        while (iterator.hasNext() && k-- > 0) {
            result.add(iterator.next().key)
        }
        return result
    }
}
