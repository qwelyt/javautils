package com.github.qwelyt.utils.collections;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.toList;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    /**
     * Returns a boolean to indicate if two collections contain any of the same elements.
     *
     * @param a   First collection
     * @param b   Second collection
     * @param <T> Collections must be of the same type.
     *
     * @return Boolean. True if something is the same, false otherwise.
     */
    public static <T> boolean containsAny(final Collection<T> a, final Collection<T> b) {
        return a.stream().anyMatch(b::contains);
    }


   /*========
      Copy
    =========*/

    public static <T> Collection<T> copy(final Collection<T> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(list);
    }

    public static <T> List<T> copy(final List<T> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(list);
    }

    public static <K, V> Map<K, V> copy(final Map<K, V> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public static <T> Set<T> copy(final Set<T> set) {
        if (set == null) {
            return new HashSet<>();
        }
        return new HashSet<>(set);
    }

    public static <T> SortedSet<T> copy(final SortedSet<T> set) {
        if (set == null) {
            return new TreeSet<>();
        }
        return new TreeSet<>(set);
    }

   /*========
      Copy with filters
    =========*/

    public static <T> List<T> copy(final List<T> list, final Predicate<T> filter) {
        if (list == null) {
            return new ArrayList<>();
        }
        return list.stream().filter(filter).collect(toList());
    }

    public static <K, V> Map<K, V> copy(final Map<K, V> map, final Predicate<Map.Entry<K, V>> filter) {
        if (map == null) {
            return new HashMap<>();
        }
        return map.entrySet().stream().filter(filter).collect(Collectors.toMap(e -> (K) e.getKey(), e -> (V) e.getValue()));
    }

    public static <T> Set<T> copy(final Set<T> set, final Predicate<T> filter) {
        if (set == null) {
            return new HashSet<>();
        }
        return set.stream().filter(filter).collect(Collectors.toSet());
    }

    /*========
       Unmodifiable
     =========*/
    public static <T> List<T> unmodifiable(final List<T> list) {
        if (list == null) {
            return unmodifiableList(emptyList());
        }
        return unmodifiableList(list);
    }

    public static <K, V> Map<K, V> unmodifiable(final Map<K, V> map) {
        if (map == null) {
            return unmodifiableMap(emptyMap());
        }
        return unmodifiableMap(map);
    }

    public static <T> Set<T> unmodifiable(final Set<T> set) {
        if (set == null) {
            return unmodifiableSet(Collections.emptySet());
        }
        return unmodifiableSet(set);
    }

   /*========
      Transformers
    =========*/

    public static <T> Set<T> toSet(final Collection<T> collection) {
        if (collection == null) {
            return new HashSet<>();
        }
        return new HashSet<>(collection);
    }

   /*========
      Creators
    =========*/

    /**
     * Returns a Set copy of the given array in analogy with {@link java.util.Arrays#asList}.
     * But a difference is that this method will copy the elements of the array
     * into the set.
     * <p/>
     * <p>This method also provides a convenient way to create a fixed-size
     * set initialized to contain several elements:
     * <pre>
     *     Set&lt;String&gt; stooges = Arrays.asSet("Larry", "Moe", "Curly");
     * </pre>
     *
     * @param a the array to be copied into the Set
     * @return a Set copy of the specified array
     */
    @SafeVarargs
    public static <T> Set<T> asSet(final T... a) {
        return Stream.of(a).collect(Collectors.toSet());
    }

    /**
     * Concatenate lists into one
     * @param lists Lists to concatenate
     * @param <T> Type
     * @return One list
     */
    public static <T> List<T> concat(final List<T>... lists){
        return Stream.of(lists).flatMap(List::stream).collect(toList());
    }




}
