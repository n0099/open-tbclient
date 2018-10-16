package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] hWV;
    private final com.facebook.common.references.c<byte[]> hWW;
    private int hWX = 0;
    private int hWY = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.hWV = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.hWW = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.hWY <= this.hWX);
        bRG();
        if (!bRF()) {
            return -1;
        }
        byte[] bArr = this.hWV;
        int i = this.hWY;
        this.hWY = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.hWY <= this.hWX);
        bRG();
        if (!bRF()) {
            return -1;
        }
        int min = Math.min(this.hWX - this.hWY, i2);
        System.arraycopy(this.hWV, this.hWY, bArr, i, min);
        this.hWY += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.hWY <= this.hWX);
        bRG();
        return (this.hWX - this.hWY) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.hWW.release(this.hWV);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.hWY <= this.hWX);
        bRG();
        int i = this.hWX - this.hWY;
        if (i >= j) {
            this.hWY = (int) (this.hWY + j);
            return j;
        }
        this.hWY = this.hWX;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean bRF() throws IOException {
        if (this.hWY < this.hWX) {
            return true;
        }
        int read = this.mInputStream.read(this.hWV);
        if (read <= 0) {
            return false;
        }
        this.hWX = read;
        this.hWY = 0;
        return true;
    }

    private void bRG() throws IOException {
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
