package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> nKD;
    private int nKE = 0;
    private int nKF = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.nKD = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.nKF <= this.nKE);
        dWw();
        if (!dWv()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.nKF;
        this.nKF = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.nKF <= this.nKE);
        dWw();
        if (!dWv()) {
            return -1;
        }
        int min = Math.min(this.nKE - this.nKF, i2);
        System.arraycopy(this.mByteArray, this.nKF, bArr, i, min);
        this.nKF += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.nKF <= this.nKE);
        dWw();
        return (this.nKE - this.nKF) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.nKD.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.nKF <= this.nKE);
        dWw();
        int i = this.nKE - this.nKF;
        if (i >= j) {
            this.nKF = (int) (this.nKF + j);
            return j;
        }
        this.nKF = this.nKE;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dWv() throws IOException {
        if (this.nKF < this.nKE) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.nKE = read;
        this.nKF = 0;
        return true;
    }

    private void dWw() throws IOException {
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
