package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final com.facebook.common.references.c<byte[]> mIT;
    private final InputStream mInputStream;
    private int mIU = 0;
    private int mIV = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.mIT = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.mIV <= this.mIU);
        dzr();
        if (!dzq()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mIV;
        this.mIV = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.mIV <= this.mIU);
        dzr();
        if (!dzq()) {
            return -1;
        }
        int min = Math.min(this.mIU - this.mIV, i2);
        System.arraycopy(this.mByteArray, this.mIV, bArr, i, min);
        this.mIV += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.mIV <= this.mIU);
        dzr();
        return (this.mIU - this.mIV) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mIT.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.mIV <= this.mIU);
        dzr();
        int i = this.mIU - this.mIV;
        if (i >= j) {
            this.mIV = (int) (this.mIV + j);
            return j;
        }
        this.mIV = this.mIU;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dzq() throws IOException {
        if (this.mIV < this.mIU) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mIU = read;
        this.mIV = 0;
        return true;
    }

    private void dzr() throws IOException {
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
