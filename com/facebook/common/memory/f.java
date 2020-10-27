package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> oBW;
    private int oBX = 0;
    private int oBY = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.oBW = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.oBY <= this.oBX);
        egu();
        if (!egt()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.oBY;
        this.oBY = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.oBY <= this.oBX);
        egu();
        if (!egt()) {
            return -1;
        }
        int min = Math.min(this.oBX - this.oBY, i2);
        System.arraycopy(this.mByteArray, this.oBY, bArr, i, min);
        this.oBY += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.oBY <= this.oBX);
        egu();
        return (this.oBX - this.oBY) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.oBW.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.oBY <= this.oBX);
        egu();
        int i = this.oBX - this.oBY;
        if (i >= j) {
            this.oBY = (int) (this.oBY + j);
            return j;
        }
        this.oBY = this.oBX;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean egt() throws IOException {
        if (this.oBY < this.oBX) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.oBX = read;
        this.oBY = 0;
        return true;
    }

    private void egu() throws IOException {
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
