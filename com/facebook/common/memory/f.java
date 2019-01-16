package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] ikk;
    private final com.facebook.common.references.c<byte[]> ikl;
    private int ikm = 0;
    private int ikn = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.ikk = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.ikl = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.ikn <= this.ikm);
        bUF();
        if (!bUE()) {
            return -1;
        }
        byte[] bArr = this.ikk;
        int i = this.ikn;
        this.ikn = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.ikn <= this.ikm);
        bUF();
        if (!bUE()) {
            return -1;
        }
        int min = Math.min(this.ikm - this.ikn, i2);
        System.arraycopy(this.ikk, this.ikn, bArr, i, min);
        this.ikn += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.ikn <= this.ikm);
        bUF();
        return (this.ikm - this.ikn) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.ikl.release(this.ikk);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.ikn <= this.ikm);
        bUF();
        int i = this.ikm - this.ikn;
        if (i >= j) {
            this.ikn = (int) (this.ikn + j);
            return j;
        }
        this.ikn = this.ikm;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean bUE() throws IOException {
        if (this.ikn < this.ikm) {
            return true;
        }
        int read = this.mInputStream.read(this.ikk);
        if (read <= 0) {
            return false;
        }
        this.ikm = read;
        this.ikn = 0;
        return true;
    }

    private void bUF() throws IOException {
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
