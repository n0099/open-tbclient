package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] hWW;
    private final com.facebook.common.references.c<byte[]> hWX;
    private int hWY = 0;
    private int hWZ = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.hWW = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.hWX = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.hWZ <= this.hWY);
        bRG();
        if (!bRF()) {
            return -1;
        }
        byte[] bArr = this.hWW;
        int i = this.hWZ;
        this.hWZ = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.hWZ <= this.hWY);
        bRG();
        if (!bRF()) {
            return -1;
        }
        int min = Math.min(this.hWY - this.hWZ, i2);
        System.arraycopy(this.hWW, this.hWZ, bArr, i, min);
        this.hWZ += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.hWZ <= this.hWY);
        bRG();
        return (this.hWY - this.hWZ) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.hWX.release(this.hWW);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.hWZ <= this.hWY);
        bRG();
        int i = this.hWY - this.hWZ;
        if (i >= j) {
            this.hWZ = (int) (this.hWZ + j);
            return j;
        }
        this.hWZ = this.hWY;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean bRF() throws IOException {
        if (this.hWZ < this.hWY) {
            return true;
        }
        int read = this.mInputStream.read(this.hWW);
        if (read <= 0) {
            return false;
        }
        this.hWY = read;
        this.hWZ = 0;
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
