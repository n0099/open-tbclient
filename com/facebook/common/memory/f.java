package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lIK;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lIL = 0;
    private int lIM = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lIK = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lIM <= this.lIL);
        dkP();
        if (!dkO()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lIM;
        this.lIM = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lIM <= this.lIL);
        dkP();
        if (!dkO()) {
            return -1;
        }
        int min = Math.min(this.lIL - this.lIM, i2);
        System.arraycopy(this.mByteArray, this.lIM, bArr, i, min);
        this.lIM += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lIM <= this.lIL);
        dkP();
        return (this.lIL - this.lIM) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lIK.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lIM <= this.lIL);
        dkP();
        int i = this.lIL - this.lIM;
        if (i >= j) {
            this.lIM = (int) (this.lIM + j);
            return j;
        }
        this.lIM = this.lIL;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dkO() throws IOException {
        if (this.lIM < this.lIL) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lIL = read;
        this.lIM = 0;
        return true;
    }

    private void dkP() throws IOException {
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
