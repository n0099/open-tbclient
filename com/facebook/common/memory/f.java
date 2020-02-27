package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lIx;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lIy = 0;
    private int lIz = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lIx = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lIz <= this.lIy);
        dkM();
        if (!dkL()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lIz;
        this.lIz = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lIz <= this.lIy);
        dkM();
        if (!dkL()) {
            return -1;
        }
        int min = Math.min(this.lIy - this.lIz, i2);
        System.arraycopy(this.mByteArray, this.lIz, bArr, i, min);
        this.lIz += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lIz <= this.lIy);
        dkM();
        return (this.lIy - this.lIz) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lIx.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lIz <= this.lIy);
        dkM();
        int i = this.lIy - this.lIz;
        if (i >= j) {
            this.lIz = (int) (this.lIz + j);
            return j;
        }
        this.lIz = this.lIy;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dkL() throws IOException {
        if (this.lIz < this.lIy) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lIy = read;
        this.lIz = 0;
        return true;
    }

    private void dkM() throws IOException {
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
