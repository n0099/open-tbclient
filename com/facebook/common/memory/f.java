package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> ptp;
    private int ptq = 0;
    private int ptr = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.ptp = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.ptr <= this.ptq);
        eug();
        if (!euf()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.ptr;
        this.ptr = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.ptr <= this.ptq);
        eug();
        if (!euf()) {
            return -1;
        }
        int min = Math.min(this.ptq - this.ptr, i2);
        System.arraycopy(this.mByteArray, this.ptr, bArr, i, min);
        this.ptr += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.ptr <= this.ptq);
        eug();
        return (this.ptq - this.ptr) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.ptp.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.ptr <= this.ptq);
        eug();
        int i = this.ptq - this.ptr;
        if (i >= j) {
            this.ptr = (int) (this.ptr + j);
            return j;
        }
        this.ptr = this.ptq;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean euf() throws IOException {
        if (this.ptr < this.ptq) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.ptq = read;
        this.ptr = 0;
        return true;
    }

    private void eug() throws IOException {
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
