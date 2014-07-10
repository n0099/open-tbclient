package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class BrokenInputStream extends InputStream {
    private final IOException exception;

    public BrokenInputStream(IOException iOException) {
        this.exception = iOException;
    }

    public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }

    @Override // java.io.InputStream
    public int read() {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public int available() {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public void reset() {
        throw this.exception;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw this.exception;
    }
}
