package com.google.zxing;
/* loaded from: classes9.dex */
public final class FormatException extends ReaderException {
    public static final FormatException INSTANCE;

    static {
        FormatException formatException = new FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(ReaderException.NO_TRACE);
    }

    public FormatException() {
    }

    public static FormatException getFormatInstance() {
        if (ReaderException.isStackTrace) {
            return new FormatException();
        }
        return INSTANCE;
    }

    public FormatException(Throwable th) {
        super(th);
    }

    public static FormatException getFormatInstance(Throwable th) {
        if (ReaderException.isStackTrace) {
            return new FormatException(th);
        }
        return INSTANCE;
    }
}
