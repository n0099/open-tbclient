package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream EY;
    private final byte[] jSk;
    private final com.facebook.common.references.c<byte[]> jSl;
    private int jSm = 0;
    private int jSn = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.EY = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jSk = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jSl = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jSn <= this.jSm);
        cBI();
        if (!cBH()) {
            return -1;
        }
        byte[] bArr = this.jSk;
        int i = this.jSn;
        this.jSn = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jSn <= this.jSm);
        cBI();
        if (!cBH()) {
            return -1;
        }
        int min = Math.min(this.jSm - this.jSn, i2);
        System.arraycopy(this.jSk, this.jSn, bArr, i, min);
        this.jSn += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jSn <= this.jSm);
        cBI();
        return (this.jSm - this.jSn) + this.EY.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jSl.release(this.jSk);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jSn <= this.jSm);
        cBI();
        int i = this.jSm - this.jSn;
        if (i >= j) {
            this.jSn = (int) (this.jSn + j);
            return j;
        }
        this.jSn = this.jSm;
        return i + this.EY.skip(j - i);
    }

    private boolean cBH() throws IOException {
        if (this.jSn < this.jSm) {
            return true;
        }
        int read = this.EY.read(this.jSk);
        if (read <= 0) {
            return false;
        }
        this.jSm = read;
        this.jSn = 0;
        return true;
    }

    private void cBI() throws IOException {
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
