package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes13.dex */
public class f extends InputStream {
    private final com.facebook.common.references.c<byte[]> lKq;
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private int lKr = 0;
    private int lKs = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.lKq = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.lKs <= this.lKr);
        dlm();
        if (!dll()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.lKs;
        this.lKs = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.lKs <= this.lKr);
        dlm();
        if (!dll()) {
            return -1;
        }
        int min = Math.min(this.lKr - this.lKs, i2);
        System.arraycopy(this.mByteArray, this.lKs, bArr, i, min);
        this.lKs += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.lKs <= this.lKr);
        dlm();
        return (this.lKr - this.lKs) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.lKq.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.lKs <= this.lKr);
        dlm();
        int i = this.lKr - this.lKs;
        if (i >= j) {
            this.lKs = (int) (this.lKs + j);
            return j;
        }
        this.lKs = this.lKr;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean dll() throws IOException {
        if (this.lKs < this.lKr) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.lKr = read;
        this.lKs = 0;
        return true;
    }

    private void dlm() throws IOException {
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
