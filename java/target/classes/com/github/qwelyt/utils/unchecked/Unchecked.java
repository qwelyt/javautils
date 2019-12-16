package com.github.qwelyt.utils.unchecked;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

/**
 * Turn CheckedExceptions into UncheckedExceptions
 * <p>
 * When you don't want to be forced to deal with CheckedException, wrap them and turn them into UncheckedExceptions.
 * This is very useful when doing lambdas.
 * <p>
 * Usage: Runnable {@code Unchecked.wrap(Thread.sleep(200));}
 * <p>
 * Supplier {@code Thing thing = Unchecked.wrap(() -> CheckedExceptionThrower.thing())}
 * <p>
 * Function {@code Thing thing = Unchecked.wrap(param -> CheckedExceptionThrower.thing(param))}
 */
public final class Unchecked {
    private Unchecked() {
    }

    /**
     * Run the thing you want without worrying about the CheckedException
     *
     * @param block Thing to run eg {@code Unchecked.wrap(() -> Thread.sleep(100))}
     */
    public static void wrap(final CheckedRunnable block) {
        try {
            block.run();
        } catch (final Throwable ex) {
            throw propagate(ex);
        }
    }

    /**
     * Get the thing you want without worrying about the CheckedException
     *
     * @param block Thing to run to get your thing eg. {@code Unchecked.wrap(() -> getThing()}
     * @param <T>   Type you want to get back
     *
     * @return The thing you asked for
     */
    public static <T> T wrap(final CheckedSupplier<T> block) {
        try {
            return block.get();
        } catch (final Throwable ex) {
            throw propagate(ex);
        }
    }

    /**
     * Get the thing you want without worrying about the CheckedException
     *
     * @param function Thing to run to get your thing eg. {@code Unchecked.wrap(() -> getThing()}
     * @param <T>      Pram of the function you are using
     * @param <R>      Returned objects type
     *
     * @return The thing you asked for
     */
    public static <T, R> Function<T, R> function(final CheckedFunction<T, R> function) {
        return (t) -> {
            try {
                return function.apply(t);
            } catch (final Throwable ex) {
                throw propagate(ex);
            }
        };
    }

    /**
     * Propagate the Throwable into an unchecked version of it
     *
     * @param throwable The offerender
     *
     * @return A nice unchecked version of the offender
     */
    public static RuntimeException propagate(final Throwable throwable) {
        if (throwable instanceof InvocationTargetException) {
            throw propagate(throwable.getCause());
        } else if (throwable instanceof IOException) {
            throw new UncheckedIOException((IOException) throwable);
        } else if (throwable instanceof ReflectiveOperationException) {
            throw new UncheckedReflectiveOperationException((ReflectiveOperationException) throwable);
        } else {
            throw new RuntimeException(throwable);
        }
    }
}

