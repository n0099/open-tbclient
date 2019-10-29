package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] kbd;
    private final com.facebook.common.references.c<byte[]> kbe;
    private int kbf = 0;
    private int kbg = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.kbd = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.kbe = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.kbg <= this.kbf);
        cCP();
        if (!cCO()) {
            return -1;
        }
        byte[] bArr = this.kbd;
        int i = this.kbg;
        this.kbg = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.kbg <= this.kbf);
        cCP();
        if (!cCO()) {
            return -1;
        }
        int min = Math.min(this.kbf - this.kbg, i2);
        System.arraycopy(this.kbd, this.kbg, bArr, i, min);
        this.kbg += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.kbg <= this.kbf);
        cCP();
        return (this.kbf - this.kbg) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.kbe.release(this.kbd);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.kbg <= this.kbf);
        cCP();
        int i = this.kbf - this.kbg;
        if (i >= j) {
            this.kbg = (int) (this.kbg + j);
            return j;
        }
        this.kbg = this.kbf;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean cCO() throws IOException {
        if (this.kbg < this.kbf) {
            return true;
        }
        int read = this.mInputStream.read(this.kbd);
        if (read <= 0) {
            return false;
        }
        this.kbf = read;
        this.kbg = 0;
        return true;
    }

    private void cCP() throws IOException {
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
