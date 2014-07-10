package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class BrokenOutputStream extends OutputStream {
    private final IOException exception;

    public BrokenOutputStream(IOException iOException) {
        this.exception = iOException;
    }

    public BrokenOutputStream() {
        this(new IOException("Broken output stream"));
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw this.exception;
    }
}
