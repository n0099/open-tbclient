package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> pzz;
    private int pzA = 0;
    private int mBufferOffset = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.pzz = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.mBufferOffset <= this.pzA);
        esN();
        if (!esM()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mBufferOffset;
        this.mBufferOffset = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.mBufferOffset <= this.pzA);
        esN();
        if (!esM()) {
            return -1;
        }
        int min = Math.min(this.pzA - this.mBufferOffset, i2);
        System.arraycopy(this.mByteArray, this.mBufferOffset, bArr, i, min);
        this.mBufferOffset += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.mBufferOffset <= this.pzA);
        esN();
        return (this.pzA - this.mBufferOffset) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.pzz.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.mBufferOffset <= this.pzA);
        esN();
        int i = this.pzA - this.mBufferOffset;
        if (i >= j) {
            this.mBufferOffset = (int) (this.mBufferOffset + j);
            return j;
        }
        this.mBufferOffset = this.pzA;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean esM() throws IOException {
        if (this.mBufferOffset < this.pzA) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.pzA = read;
        this.mBufferOffset = 0;
        return true;
    }

    private void esN() throws IOException {
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
