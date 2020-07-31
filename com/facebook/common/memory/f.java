package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> mQV;
    private int mQW = 0;
    private int mQX = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.mQV = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.mQX <= this.mQW);
        dCD();
        if (!dCC()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mQX;
        this.mQX = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.mQX <= this.mQW);
        dCD();
        if (!dCC()) {
            return -1;
        }
        int min = Math.min(this.mQW - this.mQX, i2);
        System.arraycopy(this.mByteArray, this.mQX, bArr, i, min);
        this.mQX += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.mQX <= this.mQW);
        dCD();
        return (this.mQW - this.mQX) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mQV.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.mQX <= this.mQW);
        dCD();
        int i = this.mQW - this.mQX;
        if (i >= j) {
            this.mQX = (int) (this.mQX + j);
            return j;
        }
        this.mQX = this.mQW;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dCC() throws IOException {
        if (this.mQX < this.mQW) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mQW = read;
        this.mQX = 0;
        return true;
    }

    private void dCD() throws IOException {
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
