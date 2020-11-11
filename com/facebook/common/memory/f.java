package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> oLp;
    private int oLq = 0;
    private int oLr = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.oLp = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.oLr <= this.oLq);
        ekj();
        if (!eki()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.oLr;
        this.oLr = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.oLr <= this.oLq);
        ekj();
        if (!eki()) {
            return -1;
        }
        int min = Math.min(this.oLq - this.oLr, i2);
        System.arraycopy(this.mByteArray, this.oLr, bArr, i, min);
        this.oLr += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.oLr <= this.oLq);
        ekj();
        return (this.oLq - this.oLr) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.oLp.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.oLr <= this.oLq);
        ekj();
        int i = this.oLq - this.oLr;
        if (i >= j) {
            this.oLr = (int) (this.oLr + j);
            return j;
        }
        this.oLr = this.oLq;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean eki() throws IOException {
        if (this.oLr < this.oLq) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.oLq = read;
        this.oLr = 0;
        return true;
    }

    private void ekj() throws IOException {
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
