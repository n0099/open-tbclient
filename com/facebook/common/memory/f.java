package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lHL;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lHM = 0;
    private int lHN = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lHL = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lHN <= this.lHM);
        djx();
        if (!djw()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lHN;
        this.lHN = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lHN <= this.lHM);
        djx();
        if (!djw()) {
            return -1;
        }
        int min = Math.min(this.lHM - this.lHN, i2);
        System.arraycopy(this.mByteArray, this.lHN, bArr, i, min);
        this.lHN += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lHN <= this.lHM);
        djx();
        return (this.lHM - this.lHN) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lHL.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lHN <= this.lHM);
        djx();
        int i = this.lHM - this.lHN;
        if (i >= j) {
            this.lHN = (int) (this.lHN + j);
            return j;
        }
        this.lHN = this.lHM;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean djw() throws IOException {
        if (this.lHN < this.lHM) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lHM = read;
        this.lHN = 0;
        return true;
    }

    private void djx() throws IOException {
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
