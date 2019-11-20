package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] kam;
    private final com.facebook.common.references.c<byte[]> kan;
    private int kao = 0;
    private int kap = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.kam = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.kan = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.kap <= this.kao);
        cCN();
        if (!cCM()) {
            return -1;
        }
        byte[] bArr = this.kam;
        int i = this.kap;
        this.kap = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.kap <= this.kao);
        cCN();
        if (!cCM()) {
            return -1;
        }
        int min = Math.min(this.kao - this.kap, i2);
        System.arraycopy(this.kam, this.kap, bArr, i, min);
        this.kap += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.kap <= this.kao);
        cCN();
        return (this.kao - this.kap) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.kan.release(this.kam);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.kap <= this.kao);
        cCN();
        int i = this.kao - this.kap;
        if (i >= j) {
            this.kap = (int) (this.kap + j);
            return j;
        }
        this.kap = this.kao;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean cCM() throws IOException {
        if (this.kap < this.kao) {
            return true;
        }
        int read = this.mInputStream.read(this.kam);
        if (read <= 0) {
            return false;
        }
        this.kao = read;
        this.kap = 0;
        return true;
    }

    private void cCN() throws IOException {
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
