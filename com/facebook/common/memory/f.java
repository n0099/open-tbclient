package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> pti;
    private int ptj = 0;
    private int ptk = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.pti = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.ptk <= this.ptj);
        eua();
        if (!etZ()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.ptk;
        this.ptk = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.ptk <= this.ptj);
        eua();
        if (!etZ()) {
            return -1;
        }
        int min = Math.min(this.ptj - this.ptk, i2);
        System.arraycopy(this.mByteArray, this.ptk, bArr, i, min);
        this.ptk += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.ptk <= this.ptj);
        eua();
        return (this.ptj - this.ptk) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.pti.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.ptk <= this.ptj);
        eua();
        int i = this.ptj - this.ptk;
        if (i >= j) {
            this.ptk = (int) (this.ptk + j);
            return j;
        }
        this.ptk = this.ptj;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean etZ() throws IOException {
        if (this.ptk < this.ptj) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.ptj = read;
        this.ptk = 0;
        return true;
    }

    private void eua() throws IOException {
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
