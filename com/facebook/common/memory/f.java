package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final com.facebook.common.references.c<byte[]> mIQ;
    private final InputStream mInputStream;
    private int mIR = 0;
    private int mIS = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.mIQ = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.mIS <= this.mIR);
        dzn();
        if (!dzm()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mIS;
        this.mIS = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.mIS <= this.mIR);
        dzn();
        if (!dzm()) {
            return -1;
        }
        int min = Math.min(this.mIR - this.mIS, i2);
        System.arraycopy(this.mByteArray, this.mIS, bArr, i, min);
        this.mIS += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.mIS <= this.mIR);
        dzn();
        return (this.mIR - this.mIS) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mIQ.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.mIS <= this.mIR);
        dzn();
        int i = this.mIR - this.mIS;
        if (i >= j) {
            this.mIS = (int) (this.mIS + j);
            return j;
        }
        this.mIS = this.mIR;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dzm() throws IOException {
        if (this.mIS < this.mIR) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mIR = read;
        this.mIS = 0;
        return true;
    }

    private void dzn() throws IOException {
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
