package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Hn;
    private final byte[] jzY;
    private final com.facebook.common.references.c<byte[]> jzZ;
    private int jAa = 0;
    private int jAb = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Hn = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jzY = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jzZ = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jAb <= this.jAa);
        ctQ();
        if (!ctP()) {
            return -1;
        }
        byte[] bArr = this.jzY;
        int i = this.jAb;
        this.jAb = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jAb <= this.jAa);
        ctQ();
        if (!ctP()) {
            return -1;
        }
        int min = Math.min(this.jAa - this.jAb, i2);
        System.arraycopy(this.jzY, this.jAb, bArr, i, min);
        this.jAb += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jAb <= this.jAa);
        ctQ();
        return (this.jAa - this.jAb) + this.Hn.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jzZ.release(this.jzY);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jAb <= this.jAa);
        ctQ();
        int i = this.jAa - this.jAb;
        if (i >= j) {
            this.jAb = (int) (this.jAb + j);
            return j;
        }
        this.jAb = this.jAa;
        return i + this.Hn.skip(j - i);
    }

    private boolean ctP() throws IOException {
        if (this.jAb < this.jAa) {
            return true;
        }
        int read = this.Hn.read(this.jzY);
        if (read <= 0) {
            return false;
        }
        this.jAa = read;
        this.jAb = 0;
        return true;
    }

    private void ctQ() throws IOException {
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
