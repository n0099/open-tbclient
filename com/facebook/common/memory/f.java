package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] ifT;
    private final com.facebook.common.references.c<byte[]> ifU;
    private int ifV = 0;
    private int ifW = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.ifT = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.ifU = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.ifW <= this.ifV);
        bTg();
        if (!bTf()) {
            return -1;
        }
        byte[] bArr = this.ifT;
        int i = this.ifW;
        this.ifW = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.ifW <= this.ifV);
        bTg();
        if (!bTf()) {
            return -1;
        }
        int min = Math.min(this.ifV - this.ifW, i2);
        System.arraycopy(this.ifT, this.ifW, bArr, i, min);
        this.ifW += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.ifW <= this.ifV);
        bTg();
        return (this.ifV - this.ifW) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.ifU.release(this.ifT);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.ifW <= this.ifV);
        bTg();
        int i = this.ifV - this.ifW;
        if (i >= j) {
            this.ifW = (int) (this.ifW + j);
            return j;
        }
        this.ifW = this.ifV;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean bTf() throws IOException {
        if (this.ifW < this.ifV) {
            return true;
        }
        int read = this.mInputStream.read(this.ifT);
        if (read <= 0) {
            return false;
        }
        this.ifV = read;
        this.ifW = 0;
        return true;
    }

    private void bTg() throws IOException {
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
