package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Hn;
    private final byte[] jzN;
    private final com.facebook.common.references.c<byte[]> jzO;
    private int jzP = 0;
    private int jzQ = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Hn = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jzN = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jzO = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jzQ <= this.jzP);
        ctD();
        if (!ctC()) {
            return -1;
        }
        byte[] bArr = this.jzN;
        int i = this.jzQ;
        this.jzQ = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jzQ <= this.jzP);
        ctD();
        if (!ctC()) {
            return -1;
        }
        int min = Math.min(this.jzP - this.jzQ, i2);
        System.arraycopy(this.jzN, this.jzQ, bArr, i, min);
        this.jzQ += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jzQ <= this.jzP);
        ctD();
        return (this.jzP - this.jzQ) + this.Hn.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jzO.release(this.jzN);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jzQ <= this.jzP);
        ctD();
        int i = this.jzP - this.jzQ;
        if (i >= j) {
            this.jzQ = (int) (this.jzQ + j);
            return j;
        }
        this.jzQ = this.jzP;
        return i + this.Hn.skip(j - i);
    }

    private boolean ctC() throws IOException {
        if (this.jzQ < this.jzP) {
            return true;
        }
        int read = this.Hn.read(this.jzN);
        if (read <= 0) {
            return false;
        }
        this.jzP = read;
        this.jzQ = 0;
        return true;
    }

    private void ctD() throws IOException {
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
