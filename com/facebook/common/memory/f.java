package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lHQ;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lHR = 0;
    private int lHS = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lHQ = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lHS <= this.lHR);
        djz();
        if (!djy()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lHS;
        this.lHS = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lHS <= this.lHR);
        djz();
        if (!djy()) {
            return -1;
        }
        int min = Math.min(this.lHR - this.lHS, i2);
        System.arraycopy(this.mByteArray, this.lHS, bArr, i, min);
        this.lHS += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lHS <= this.lHR);
        djz();
        return (this.lHR - this.lHS) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lHQ.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lHS <= this.lHR);
        djz();
        int i = this.lHR - this.lHS;
        if (i >= j) {
            this.lHS = (int) (this.lHS + j);
            return j;
        }
        this.lHS = this.lHR;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean djy() throws IOException {
        if (this.lHS < this.lHR) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lHR = read;
        this.lHS = 0;
        return true;
    }

    private void djz() throws IOException {
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
