package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Hn;
    private final byte[] jAg;
    private final com.facebook.common.references.c<byte[]> jAh;
    private int jAi = 0;
    private int jAj = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Hn = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jAg = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jAh = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jAj <= this.jAi);
        ctN();
        if (!ctM()) {
            return -1;
        }
        byte[] bArr = this.jAg;
        int i = this.jAj;
        this.jAj = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jAj <= this.jAi);
        ctN();
        if (!ctM()) {
            return -1;
        }
        int min = Math.min(this.jAi - this.jAj, i2);
        System.arraycopy(this.jAg, this.jAj, bArr, i, min);
        this.jAj += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jAj <= this.jAi);
        ctN();
        return (this.jAi - this.jAj) + this.Hn.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jAh.release(this.jAg);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jAj <= this.jAi);
        ctN();
        int i = this.jAi - this.jAj;
        if (i >= j) {
            this.jAj = (int) (this.jAj + j);
            return j;
        }
        this.jAj = this.jAi;
        return i + this.Hn.skip(j - i);
    }

    private boolean ctM() throws IOException {
        if (this.jAj < this.jAi) {
            return true;
        }
        int read = this.Hn.read(this.jAg);
        if (read <= 0) {
            return false;
        }
        this.jAi = read;
        this.jAj = 0;
        return true;
    }

    private void ctN() throws IOException {
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
