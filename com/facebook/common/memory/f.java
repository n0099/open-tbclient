package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream EY;
    private final byte[] jSj;
    private final com.facebook.common.references.c<byte[]> jSk;
    private int jSl = 0;
    private int jSm = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.EY = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jSj = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jSk = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jSm <= this.jSl);
        cBG();
        if (!cBF()) {
            return -1;
        }
        byte[] bArr = this.jSj;
        int i = this.jSm;
        this.jSm = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jSm <= this.jSl);
        cBG();
        if (!cBF()) {
            return -1;
        }
        int min = Math.min(this.jSl - this.jSm, i2);
        System.arraycopy(this.jSj, this.jSm, bArr, i, min);
        this.jSm += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jSm <= this.jSl);
        cBG();
        return (this.jSl - this.jSm) + this.EY.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jSk.release(this.jSj);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jSm <= this.jSl);
        cBG();
        int i = this.jSl - this.jSm;
        if (i >= j) {
            this.jSm = (int) (this.jSm + j);
            return j;
        }
        this.jSm = this.jSl;
        return i + this.EY.skip(j - i);
    }

    private boolean cBF() throws IOException {
        if (this.jSm < this.jSl) {
            return true;
        }
        int read = this.EY.read(this.jSj);
        if (read <= 0) {
            return false;
        }
        this.jSl = read;
        this.jSm = 0;
        return true;
    }

    private void cBG() throws IOException {
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
