package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] hYG;
    private final com.facebook.common.references.c<byte[]> hYH;
    private int hYI = 0;
    private int hYJ = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.hYG = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.hYH = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.hYJ <= this.hYI);
        bRb();
        if (!bRa()) {
            return -1;
        }
        byte[] bArr = this.hYG;
        int i = this.hYJ;
        this.hYJ = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.hYJ <= this.hYI);
        bRb();
        if (!bRa()) {
            return -1;
        }
        int min = Math.min(this.hYI - this.hYJ, i2);
        System.arraycopy(this.hYG, this.hYJ, bArr, i, min);
        this.hYJ += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.hYJ <= this.hYI);
        bRb();
        return (this.hYI - this.hYJ) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.hYH.release(this.hYG);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.hYJ <= this.hYI);
        bRb();
        int i = this.hYI - this.hYJ;
        if (i >= j) {
            this.hYJ = (int) (this.hYJ + j);
            return j;
        }
        this.hYJ = this.hYI;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean bRa() throws IOException {
        if (this.hYJ < this.hYI) {
            return true;
        }
        int read = this.mInputStream.read(this.hYG);
        if (read <= 0) {
            return false;
        }
        this.hYI = read;
        this.hYJ = 0;
        return true;
    }

    private void bRb() throws IOException {
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
