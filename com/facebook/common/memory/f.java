package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Fe;
    private final byte[] jZr;
    private final com.facebook.common.references.c<byte[]> jZs;
    private int jZt = 0;
    private int jZu = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Fe = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jZr = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jZs = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jZu <= this.jZt);
        cEI();
        if (!cEH()) {
            return -1;
        }
        byte[] bArr = this.jZr;
        int i = this.jZu;
        this.jZu = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jZu <= this.jZt);
        cEI();
        if (!cEH()) {
            return -1;
        }
        int min = Math.min(this.jZt - this.jZu, i2);
        System.arraycopy(this.jZr, this.jZu, bArr, i, min);
        this.jZu += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jZu <= this.jZt);
        cEI();
        return (this.jZt - this.jZu) + this.Fe.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jZs.release(this.jZr);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jZu <= this.jZt);
        cEI();
        int i = this.jZt - this.jZu;
        if (i >= j) {
            this.jZu = (int) (this.jZu + j);
            return j;
        }
        this.jZu = this.jZt;
        return i + this.Fe.skip(j - i);
    }

    private boolean cEH() throws IOException {
        if (this.jZu < this.jZt) {
            return true;
        }
        int read = this.Fe.read(this.jZr);
        if (read <= 0) {
            return false;
        }
        this.jZt = read;
        this.jZu = 0;
        return true;
    }

    private void cEI() throws IOException {
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
