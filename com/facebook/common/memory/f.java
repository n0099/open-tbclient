package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lRK;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lRL = 0;
    private int lRM = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lRK = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lRM <= this.lRL);
        dnf();
        if (!dne()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lRM;
        this.lRM = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lRM <= this.lRL);
        dnf();
        if (!dne()) {
            return -1;
        }
        int min = Math.min(this.lRL - this.lRM, i2);
        System.arraycopy(this.mByteArray, this.lRM, bArr, i, min);
        this.lRM += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lRM <= this.lRL);
        dnf();
        return (this.lRL - this.lRM) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lRK.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lRM <= this.lRL);
        dnf();
        int i = this.lRL - this.lRM;
        if (i >= j) {
            this.lRM = (int) (this.lRM + j);
            return j;
        }
        this.lRM = this.lRL;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dne() throws IOException {
        if (this.lRM < this.lRL) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lRL = read;
        this.lRM = 0;
        return true;
    }

    private void dnf() throws IOException {
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
