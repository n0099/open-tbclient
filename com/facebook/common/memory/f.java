package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lRO;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lRP = 0;
    private int lRQ = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lRO = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lRQ <= this.lRP);
        dnd();
        if (!dnc()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lRQ;
        this.lRQ = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lRQ <= this.lRP);
        dnd();
        if (!dnc()) {
            return -1;
        }
        int min = Math.min(this.lRP - this.lRQ, i2);
        System.arraycopy(this.mByteArray, this.lRQ, bArr, i, min);
        this.lRQ += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lRQ <= this.lRP);
        dnd();
        return (this.lRP - this.lRQ) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lRO.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lRQ <= this.lRP);
        dnd();
        int i = this.lRP - this.lRQ;
        if (i >= j) {
            this.lRQ = (int) (this.lRQ + j);
            return j;
        }
        this.lRQ = this.lRP;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dnc() throws IOException {
        if (this.lRQ < this.lRP) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lRP = read;
        this.lRQ = 0;
        return true;
    }

    private void dnd() throws IOException {
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
