package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
/* loaded from: classes.dex */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader reader) {
        super(reader);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() {
        try {
            beforeRead(1);
            int read = this.in.read();
            afterRead(read == -1 ? -1 : 1);
            return read;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr) {
        int length;
        if (cArr == null) {
            length = 0;
        } else {
            try {
                length = cArr.length;
            } catch (IOException e) {
                handleIOException(e);
                return -1;
            }
        }
        beforeRead(length);
        int read = this.in.read(cArr);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) {
        try {
            beforeRead(i2);
            int read = this.in.read(cArr, i, i2);
            afterRead(read);
            return read;
        } catch (IOException e) {
            handleIOException(e);
            return -1;
        }
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) {
        int length;
        if (charBuffer == null) {
            length = 0;
        } else {
            try {
                length = charBuffer.length();
            } catch (IOException e) {
                handleIOException(e);
                return -1;
            }
        }
        beforeRead(length);
        int read = this.in.read(charBuffer);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j) {
        try {
            return this.in.skip(j);
        } catch (IOException e) {
            handleIOException(e);
            return 0L;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() {
        try {
            return this.in.ready();
        } catch (IOException e) {
            handleIOException(e);
            return false;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.in.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void mark(int i) {
        try {
            this.in.mark(i);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void reset() {
        try {
            this.in.reset();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return this.in.markSupported();
    }

    protected void beforeRead(int i) {
    }

    protected void afterRead(int i) {
    }

    protected void handleIOException(IOException iOException) {
        throw iOException;
    }
}
