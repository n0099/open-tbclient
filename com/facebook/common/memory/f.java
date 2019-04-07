package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream Hn;
    private final byte[] jzs;
    private final com.facebook.common.references.c<byte[]> jzt;
    private int jzu = 0;
    private int jzv = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.Hn = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.jzs = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.jzt = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.jzv <= this.jzu);
        ctJ();
        if (!ctI()) {
            return -1;
        }
        byte[] bArr = this.jzs;
        int i = this.jzv;
        this.jzv = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.jzv <= this.jzu);
        ctJ();
        if (!ctI()) {
            return -1;
        }
        int min = Math.min(this.jzu - this.jzv, i2);
        System.arraycopy(this.jzs, this.jzv, bArr, i, min);
        this.jzv += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.jzv <= this.jzu);
        ctJ();
        return (this.jzu - this.jzv) + this.Hn.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.jzt.release(this.jzs);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.jzv <= this.jzu);
        ctJ();
        int i = this.jzu - this.jzv;
        if (i >= j) {
            this.jzv = (int) (this.jzv + j);
            return j;
        }
        this.jzv = this.jzu;
        return i + this.Hn.skip(j - i);
    }

    private boolean ctI() throws IOException {
        if (this.jzv < this.jzu) {
            return true;
        }
        int read = this.Hn.read(this.jzs);
        if (read <= 0) {
            return false;
        }
        this.jzu = read;
        this.jzv = 0;
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
