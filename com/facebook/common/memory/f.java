package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> mmQ;
    private int mmR = 0;
    private int mmS = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.mmQ = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.mmS <= this.mmR);
        duK();
        if (!duJ()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mmS;
        this.mmS = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.mmS <= this.mmR);
        duK();
        if (!duJ()) {
            return -1;
        }
        int min = Math.min(this.mmR - this.mmS, i2);
        System.arraycopy(this.mByteArray, this.mmS, bArr, i, min);
        this.mmS += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.mmS <= this.mmR);
        duK();
        return (this.mmR - this.mmS) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mmQ.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.mmS <= this.mmR);
        duK();
        int i = this.mmR - this.mmS;
        if (i >= j) {
            this.mmS = (int) (this.mmS + j);
            return j;
        }
        this.mmS = this.mmR;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean duJ() throws IOException {
        if (this.mmS < this.mmR) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mmR = read;
        this.mmS = 0;
        return true;
    }

    private void duK() throws IOException {
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
