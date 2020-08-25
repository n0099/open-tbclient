package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes9.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> nkS;
    private int nkT = 0;
    private int nkU = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.nkS = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.nkU <= this.nkT);
        dOE();
        if (!dOD()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.nkU;
        this.nkU = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.nkU <= this.nkT);
        dOE();
        if (!dOD()) {
            return -1;
        }
        int min = Math.min(this.nkT - this.nkU, i2);
        System.arraycopy(this.mByteArray, this.nkU, bArr, i, min);
        this.nkU += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.nkU <= this.nkT);
        dOE();
        return (this.nkT - this.nkU) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.nkS.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.nkU <= this.nkT);
        dOE();
        int i = this.nkT - this.nkU;
        if (i >= j) {
            this.nkU = (int) (this.nkU + j);
            return j;
        }
        this.nkU = this.nkT;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dOD() throws IOException {
        if (this.nkU < this.nkT) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.nkT = read;
        this.nkU = 0;
        return true;
    }

    private void dOE() throws IOException {
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
