package com.github.qwelyt.utils.unchecked;

/**
 * Checked version of {@link java.util.function.Function}
 * <p>
 * Use this with {@link Unchecked}
 *
 * @param <T> the type of the object parameter
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface CheckedFunction<T, R> {

    /**
     * Returns a function that returns its input argument.
     *
     * @param <T> The type of input and output
     *
     * @return a function that returns its input argument
     */
    static <T> CheckedFunction<T, T> identity() {
        return t -> t;
    }

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     *
     * @return the function result
     *
     * @throws Throwable if an error occurs
     */
    R apply(T t) throws Throwable;
}

