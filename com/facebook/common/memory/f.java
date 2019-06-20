package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream EX;
    private final byte[] jSn;
    private final com.facebook.common.references.c<byte[]> jSo;
    private int jSp = 0;
    private int jSq = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.EX = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jSn = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jSo = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jSq <= this.jSp);
        cBH();
        if (!cBG()) {
            return -1;
        }
        byte[] bArr = this.jSn;
        int i = this.jSq;
        this.jSq = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jSq <= this.jSp);
        cBH();
        if (!cBG()) {
            return -1;
        }
        int min = Math.min(this.jSp - this.jSq, i2);
        System.arraycopy(this.jSn, this.jSq, bArr, i, min);
        this.jSq += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jSq <= this.jSp);
        cBH();
        return (this.jSp - this.jSq) + this.EX.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jSo.release(this.jSn);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jSq <= this.jSp);
        cBH();
        int i = this.jSp - this.jSq;
        if (i >= j) {
            this.jSq = (int) (this.jSq + j);
            return j;
        }
        this.jSq = this.jSp;
        return i + this.EX.skip(j - i);
    }

    private boolean cBG() throws IOException {
        if (this.jSq < this.jSp) {
            return true;
        }
        int read = this.EX.read(this.jSn);
        if (read <= 0) {
            return false;
        }
        this.jSp = read;
        this.jSq = 0;
        return true;
    }

    private void cBH() throws IOException {
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
