package com.github.qwelyt.utils.unchecked;

/**
 * An unchecked reflection exception.
 * <p>
 * This is used by {@link Unchecked} to wrap instances of {@link ReflectiveOperationException}.
 */

public final class UncheckedReflectiveOperationException extends RuntimeException {

    /**
     * Serialization version
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an instance that wraps the underlying exception.
     *
     * @param ex the underlying exception, null tolerant
     */
    public UncheckedReflectiveOperationException(final ReflectiveOperationException ex) {
        super(ex);
    }
}
