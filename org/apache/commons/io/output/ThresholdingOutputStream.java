package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public abstract class ThresholdingOutputStream extends OutputStream {
    private final int threshold;
    private boolean thresholdExceeded;
    private long written;

    protected abstract OutputStream getStream();

    protected abstract void thresholdReached();

    public ThresholdingOutputStream(int i) {
        this.threshold = i;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        checkThreshold(1);
        getStream().write(i);
        this.written++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        checkThreshold(bArr.length);
        getStream().write(bArr);
        this.written += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        checkThreshold(i2);
        getStream().write(bArr, i, i2);
        this.written += i2;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        getStream().flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
        } catch (IOException e) {
        }
        getStream().close();
    }

    public int getThreshold() {
        return this.threshold;
    }

    public long getByteCount() {
        return this.written;
    }

    public boolean isThresholdExceeded() {
        return this.written > ((long) this.threshold);
    }

    protected void checkThreshold(int i) {
        if (!this.thresholdExceeded && this.written + i > this.threshold) {
            this.thresholdExceeded = true;
            thresholdReached();
        }
    }

    protected void resetByteCount() {
        this.thresholdExceeded = false;
        this.written = 0L;
    }
}
