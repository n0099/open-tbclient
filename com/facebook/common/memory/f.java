package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Fe;
    private final byte[] kcU;
    private final com.facebook.common.references.c<byte[]> kcV;
    private int kcW = 0;
    private int kcX = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Fe = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.kcU = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.kcV = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.kcX <= this.kcW);
        cFR();
        if (!cFQ()) {
            return -1;
        }
        byte[] bArr = this.kcU;
        int i = this.kcX;
        this.kcX = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.kcX <= this.kcW);
        cFR();
        if (!cFQ()) {
            return -1;
        }
        int min = Math.min(this.kcW - this.kcX, i2);
        System.arraycopy(this.kcU, this.kcX, bArr, i, min);
        this.kcX += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.kcX <= this.kcW);
        cFR();
        return (this.kcW - this.kcX) + this.Fe.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.kcV.release(this.kcU);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.kcX <= this.kcW);
        cFR();
        int i = this.kcW - this.kcX;
        if (i >= j) {
            this.kcX = (int) (this.kcX + j);
            return j;
        }
        this.kcX = this.kcW;
        return i + this.Fe.skip(j - i);
    }

    private boolean cFQ() throws IOException {
        if (this.kcX < this.kcW) {
            return true;
        }
        int read = this.Fe.read(this.kcU);
        if (read <= 0) {
            return false;
        }
        this.kcW = read;
        this.kcX = 0;
        return true;
    }

    private void cFR() throws IOException {
        if (this.mClosed) {
            throw new IOException("stream already closed");
        }
    }

    protected void finalize() throws Throwable {
        if (!this.mClosed) {
            com.facebook.common.c.a.e("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }
}
