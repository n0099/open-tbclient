package org.apache.commons.io.output;

import java.io.OutputStream;
/* loaded from: classes.dex */
public class TeeOutputStream extends ProxyOutputStream {
    protected OutputStream branch;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.branch = outputStream2;
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        super.write(bArr);
        this.branch.write(bArr);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        super.write(bArr, i, i2);
        this.branch.write(bArr, i, i2);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        super.write(i);
        this.branch.write(i);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        super.flush();
        this.branch.flush();
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } finally {
            this.branch.close();
        }
    }
}
