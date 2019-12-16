package com.github.qwelyt.utils.unchecked;

/**
 * A checked version of {@link java.lang.Runnable}.
 * <p>
 * This is intended to be used with {@link Unchecked}.
 */

@FunctionalInterface
public interface CheckedRunnable {
    void run() throws Throwable;
}

