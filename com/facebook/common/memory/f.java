package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> mlG;
    private int mlH = 0;
    private int mlI = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.mlG = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.mlI <= this.mlH);
        duw();
        if (!duv()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mlI;
        this.mlI = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.mlI <= this.mlH);
        duw();
        if (!duv()) {
            return -1;
        }
        int min = Math.min(this.mlH - this.mlI, i2);
        System.arraycopy(this.mByteArray, this.mlI, bArr, i, min);
        this.mlI += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.mlI <= this.mlH);
        duw();
        return (this.mlH - this.mlI) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mlG.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.mlI <= this.mlH);
        duw();
        int i = this.mlH - this.mlI;
        if (i >= j) {
            this.mlI = (int) (this.mlI + j);
            return j;
        }
        this.mlI = this.mlH;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean duv() throws IOException {
        if (this.mlI < this.mlH) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mlH = read;
        this.mlI = 0;
        return true;
    }

    private void duw() throws IOException {
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
