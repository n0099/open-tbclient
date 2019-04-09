package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Hn;
    private final byte[] jzt;
    private final com.facebook.common.references.c<byte[]> jzu;
    private int jzv = 0;
    private int jzw = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Hn = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jzt = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jzu = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jzw <= this.jzv);
        ctJ();
        if (!ctI()) {
            return -1;
        }
        byte[] bArr = this.jzt;
        int i = this.jzw;
        this.jzw = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jzw <= this.jzv);
        ctJ();
        if (!ctI()) {
            return -1;
        }
        int min = Math.min(this.jzv - this.jzw, i2);
        System.arraycopy(this.jzt, this.jzw, bArr, i, min);
        this.jzw += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jzw <= this.jzv);
        ctJ();
        return (this.jzv - this.jzw) + this.Hn.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jzu.release(this.jzt);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jzw <= this.jzv);
        ctJ();
        int i = this.jzv - this.jzw;
        if (i >= j) {
            this.jzw = (int) (this.jzw + j);
            return j;
        }
        this.jzw = this.jzv;
        return i + this.Hn.skip(j - i);
    }

    private boolean ctI() throws IOException {
        if (this.jzw < this.jzv) {
            return true;
        }
        int read = this.Hn.read(this.jzt);
        if (read <= 0) {
            return false;
        }
        this.jzv = read;
        this.jzw = 0;
        return true;
    }

    private void ctJ() throws IOException {
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
