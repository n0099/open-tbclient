package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes14.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> poN;
    private int poO = 0;
    private int poP = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.poN = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.poP <= this.poO);
        eqm();
        if (!eql()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.poP;
        this.poP = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.poP <= this.poO);
        eqm();
        if (!eql()) {
            return -1;
        }
        int min = Math.min(this.poO - this.poP, i2);
        System.arraycopy(this.mByteArray, this.poP, bArr, i, min);
        this.poP += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.poP <= this.poO);
        eqm();
        return (this.poO - this.poP) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.poN.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.poP <= this.poO);
        eqm();
        int i = this.poO - this.poP;
        if (i >= j) {
            this.poP = (int) (this.poP + j);
            return j;
        }
        this.poP = this.poO;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean eql() throws IOException {
        if (this.poP < this.poO) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.poO = read;
        this.poP = 0;
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
