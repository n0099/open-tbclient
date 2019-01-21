package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] ikl;
    private final com.facebook.common.references.c<byte[]> ikm;
    private int ikn = 0;
    private int iko = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.ikl = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.ikm = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.iko <= this.ikn);
        bUF();
        if (!bUE()) {
            return -1;
        }
        byte[] bArr = this.ikl;
        int i = this.iko;
        this.iko = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.iko <= this.ikn);
        bUF();
        if (!bUE()) {
            return -1;
        }
        int min = Math.min(this.ikn - this.iko, i2);
        System.arraycopy(this.ikl, this.iko, bArr, i, min);
        this.iko += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.iko <= this.ikn);
        bUF();
        return (this.ikn - this.iko) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.ikm.release(this.ikl);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.iko <= this.ikn);
        bUF();
        int i = this.ikn - this.iko;
        if (i >= j) {
            this.iko = (int) (this.iko + j);
            return j;
        }
        this.iko = this.ikn;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean bUE() throws IOException {
        if (this.iko < this.ikn) {
            return true;
        }
        int read = this.mInputStream.read(this.ikl);
        if (read <= 0) {
            return false;
        }
        this.ikn = read;
        this.iko = 0;
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
