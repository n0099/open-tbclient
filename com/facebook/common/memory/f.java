package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Fe;
    private final byte[] kax;
    private final com.facebook.common.references.c<byte[]> kay;
    private int kaz = 0;
    private int kaA = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Fe = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.kax = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.kay = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.kaA <= this.kaz);
        cFd();
        if (!cFc()) {
            return -1;
        }
        byte[] bArr = this.kax;
        int i = this.kaA;
        this.kaA = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.kaA <= this.kaz);
        cFd();
        if (!cFc()) {
            return -1;
        }
        int min = Math.min(this.kaz - this.kaA, i2);
        System.arraycopy(this.kax, this.kaA, bArr, i, min);
        this.kaA += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.kaA <= this.kaz);
        cFd();
        return (this.kaz - this.kaA) + this.Fe.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.kay.release(this.kax);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.kaA <= this.kaz);
        cFd();
        int i = this.kaz - this.kaA;
        if (i >= j) {
            this.kaA = (int) (this.kaA + j);
            return j;
        }
        this.kaA = this.kaz;
        return i + this.Fe.skip(j - i);
    }

    private boolean cFc() throws IOException {
        if (this.kaA < this.kaz) {
            return true;
        }
        int read = this.Fe.read(this.kax);
        if (read <= 0) {
            return false;
        }
        this.kaz = read;
        this.kaA = 0;
        return true;
    }

    private void cFd() throws IOException {
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
