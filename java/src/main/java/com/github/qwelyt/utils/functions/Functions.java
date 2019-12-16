package com.github.qwelyt.utils.functions;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class Functions {
    private Functions() {
    }

    public static <T, R> Function<T, Stream<R>> match(final Class<R> clazz) {
        return e -> clazz.isInstance(e) ? Stream.of(clazz.cast(e)) : null;
    }

    public static <A, B, C> C curry(final BiFunction<A, B, C> biFunction, final A a, final B b) {
        return curry(biFunction, a).apply(b);
    }

    public static <A, B, C> Function<B, C> curry(final BiFunction<A, B, C> biFunction, final A a) {
        return x -> biFunction.apply(a, x);
    }

    public static <A, B> B curry(final Function<A, B> function, final A a) {
        return function.apply(a);
    }

    public static <A, B> Predicate<B> curry(final BiPredicate<A, B> biPredicate, final A a) {
        return x -> biPredicate.test(a, x);
    }

    public static <A, B, C> BiFunction<B, A, C> reverse(final BiFunction<A, B, C> biFunction) {
        return (a, b) -> biFunction.apply(b, a);
    }

    public static <A, B> B foldLeft(final Collection<A> col, final BiFunction<B, A, B> f, final B b) {
        B x = b;

        for (final A a : col) {
            x = f.apply(x, a);
        }

        return x;
    }

}
