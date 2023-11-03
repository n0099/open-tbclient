package com.google.zxing;
/* loaded from: classes10.dex */
public final class ChecksumException extends ReaderException {
    public static final ChecksumException INSTANCE;

    static {
        ChecksumException checksumException = new ChecksumException();
        INSTANCE = checksumException;
        checksumException.setStackTrace(ReaderException.NO_TRACE);
    }

    public ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        if (ReaderException.isStackTrace) {
            return new ChecksumException();
        }
        return INSTANCE;
    }

    public ChecksumException(Throwable th) {
        super(th);
    }

    public static ChecksumException getChecksumInstance(Throwable th) {
        if (ReaderException.isStackTrace) {
            return new ChecksumException(th);
        }
        return INSTANCE;
    }
}
