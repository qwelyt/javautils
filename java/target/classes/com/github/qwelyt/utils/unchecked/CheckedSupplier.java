package com.github.qwelyt.utils.unchecked;

/**
 * Checked version of {@link java.util.function.Supplier}
 * <p>
 * Use this with {@link Unchecked}
 *
 * @param <T> the type of the result
 */
@FunctionalInterface
public interface CheckedSupplier<T> {
    T get() throws Throwable;
}

