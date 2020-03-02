package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lIz;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lIA = 0;
    private int lIB = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lIz = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lIB <= this.lIA);
        dkO();
        if (!dkN()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lIB;
        this.lIB = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lIB <= this.lIA);
        dkO();
        if (!dkN()) {
            return -1;
        }
        int min = Math.min(this.lIA - this.lIB, i2);
        System.arraycopy(this.mByteArray, this.lIB, bArr, i, min);
        this.lIB += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lIB <= this.lIA);
        dkO();
        return (this.lIA - this.lIB) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lIz.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lIB <= this.lIA);
        dkO();
        int i = this.lIA - this.lIB;
        if (i >= j) {
            this.lIB = (int) (this.lIB + j);
            return j;
        }
        this.lIB = this.lIA;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dkN() throws IOException {
        if (this.lIB < this.lIA) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lIA = read;
        this.lIB = 0;
        return true;
    }

    private void dkO() throws IOException {
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
