package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class ProxyOutputStream extends FilterOutputStream {
    public ProxyOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        try {
            beforeWrite(1);
            this.out.write(i);
            afterWrite(1);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        int length;
        if (bArr == null) {
            length = 0;
        } else {
            try {
                length = bArr.length;
            } catch (IOException e) {
                handleIOException(e);
                return;
            }
        }
        beforeWrite(length);
        this.out.write(bArr);
        afterWrite(length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        try {
            beforeWrite(i2);
            this.out.write(bArr, i, i2);
            afterWrite(i2);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    protected void beforeWrite(int i) {
    }

    protected void afterWrite(int i) {
    }

    protected void handleIOException(IOException iOException) {
        throw iOException;
    }
}
