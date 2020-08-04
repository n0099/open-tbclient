package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> mQX;
    private int mQY = 0;
    private int mQZ = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.mQX = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.mQZ <= this.mQY);
        dCE();
        if (!dCD()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mQZ;
        this.mQZ = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.mQZ <= this.mQY);
        dCE();
        if (!dCD()) {
            return -1;
        }
        int min = Math.min(this.mQY - this.mQZ, i2);
        System.arraycopy(this.mByteArray, this.mQZ, bArr, i, min);
        this.mQZ += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.mQZ <= this.mQY);
        dCE();
        return (this.mQY - this.mQZ) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mQX.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.mQZ <= this.mQY);
        dCE();
        int i = this.mQY - this.mQZ;
        if (i >= j) {
            this.mQZ = (int) (this.mQZ + j);
            return j;
        }
        this.mQZ = this.mQY;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dCD() throws IOException {
        if (this.mQZ < this.mQY) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mQY = read;
        this.mQZ = 0;
        return true;
    }

    private void dCE() throws IOException {
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
