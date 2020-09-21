package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes17.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> nvk;
    private int nvl = 0;
    private int nvm = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.nvk = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.nvm <= this.nvl);
        dSL();
        if (!dSK()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.nvm;
        this.nvm = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.nvm <= this.nvl);
        dSL();
        if (!dSK()) {
            return -1;
        }
        int min = Math.min(this.nvl - this.nvm, i2);
        System.arraycopy(this.mByteArray, this.nvm, bArr, i, min);
        this.nvm += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.nvm <= this.nvl);
        dSL();
        return (this.nvl - this.nvm) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.nvk.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.nvm <= this.nvl);
        dSL();
        int i = this.nvl - this.nvm;
        if (i >= j) {
            this.nvm = (int) (this.nvm + j);
            return j;
        }
        this.nvm = this.nvl;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dSK() throws IOException {
        if (this.nvm < this.nvl) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.nvl = read;
        this.nvm = 0;
        return true;
    }

    private void dSL() throws IOException {
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
