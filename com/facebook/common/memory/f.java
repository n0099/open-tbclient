package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes11.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lEn;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lEo = 0;
    private int lEp = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lEn = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lEp <= this.lEo);
        diw();
        if (!div()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lEp;
        this.lEp = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lEp <= this.lEo);
        diw();
        if (!div()) {
            return -1;
        }
        int min = Math.min(this.lEo - this.lEp, i2);
        System.arraycopy(this.mByteArray, this.lEp, bArr, i, min);
        this.lEp += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lEp <= this.lEo);
        diw();
        return (this.lEo - this.lEp) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lEn.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lEp <= this.lEo);
        diw();
        int i = this.lEo - this.lEp;
        if (i >= j) {
            this.lEp = (int) (this.lEp + j);
            return j;
        }
        this.lEp = this.lEo;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean div() throws IOException {
        if (this.lEp < this.lEo) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lEo = read;
        this.lEp = 0;
        return true;
    }

    private void diw() throws IOException {
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
