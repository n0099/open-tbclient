package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes14.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> poO;
    private int poP = 0;
    private int poQ = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.poO = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.poQ <= this.poP);
        eqm();
        if (!eql()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.poQ;
        this.poQ = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.poQ <= this.poP);
        eqm();
        if (!eql()) {
            return -1;
        }
        int min = Math.min(this.poP - this.poQ, i2);
        System.arraycopy(this.mByteArray, this.poQ, bArr, i, min);
        this.poQ += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.poQ <= this.poP);
        eqm();
        return (this.poP - this.poQ) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.poO.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.poQ <= this.poP);
        eqm();
        int i = this.poP - this.poQ;
        if (i >= j) {
            this.poQ = (int) (this.poQ + j);
            return j;
        }
        this.poQ = this.poP;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean eql() throws IOException {
        if (this.poQ < this.poP) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.poP = read;
        this.poQ = 0;
        return true;
    }

    private void eqm() throws IOException {
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
