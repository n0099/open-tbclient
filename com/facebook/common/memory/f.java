package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> oMT;
    private int oMU = 0;
    private int oMV = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.oMT = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.oMV <= this.oMU);
        ekh();
        if (!ekg()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.oMV;
        this.oMV = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.oMV <= this.oMU);
        ekh();
        if (!ekg()) {
            return -1;
        }
        int min = Math.min(this.oMU - this.oMV, i2);
        System.arraycopy(this.mByteArray, this.oMV, bArr, i, min);
        this.oMV += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.oMV <= this.oMU);
        ekh();
        return (this.oMU - this.oMV) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.oMT.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.oMV <= this.oMU);
        ekh();
        int i = this.oMU - this.oMV;
        if (i >= j) {
            this.oMV = (int) (this.oMV + j);
            return j;
        }
        this.oMV = this.oMU;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean ekg() throws IOException {
        if (this.oMV < this.oMU) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.oMU = read;
        this.oMV = 0;
        return true;
    }

    private void ekh() throws IOException {
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
