package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes9.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> nlk;
    private int nll = 0;
    private int nlm = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.nlk = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.nlm <= this.nll);
        dON();
        if (!dOM()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.nlm;
        this.nlm = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.nlm <= this.nll);
        dON();
        if (!dOM()) {
            return -1;
        }
        int min = Math.min(this.nll - this.nlm, i2);
        System.arraycopy(this.mByteArray, this.nlm, bArr, i, min);
        this.nlm += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.nlm <= this.nll);
        dON();
        return (this.nll - this.nlm) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.nlk.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.nlm <= this.nll);
        dON();
        int i = this.nll - this.nlm;
        if (i >= j) {
            this.nlm = (int) (this.nlm + j);
            return j;
        }
        this.nlm = this.nll;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dOM() throws IOException {
        if (this.nlm < this.nll) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.nll = read;
        this.nlm = 0;
        return true;
    }

    private void dON() throws IOException {
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
