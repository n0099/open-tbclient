package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes19.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> pcd;
    private int pce = 0;
    private int pcf = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.pcd = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.pcf <= this.pce);
        epX();
        if (!epW()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.pcf;
        this.pcf = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.pcf <= this.pce);
        epX();
        if (!epW()) {
            return -1;
        }
        int min = Math.min(this.pce - this.pcf, i2);
        System.arraycopy(this.mByteArray, this.pcf, bArr, i, min);
        this.pcf += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.pcf <= this.pce);
        epX();
        return (this.pce - this.pcf) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.pcd.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.pcf <= this.pce);
        epX();
        int i = this.pce - this.pcf;
        if (i >= j) {
            this.pcf = (int) (this.pcf + j);
            return j;
        }
        this.pcf = this.pce;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean epW() throws IOException {
        if (this.pcf < this.pce) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.pce = read;
        this.pcf = 0;
        return true;
    }

    private void epX() throws IOException {
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
