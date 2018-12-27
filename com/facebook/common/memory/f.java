package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final byte[] ijd;
    private final com.facebook.common.references.c<byte[]> ije;
    private int ijf = 0;
    private int ijg = 0;
    private boolean mClosed = false;
    private final InputStream mInputStream;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.ijd = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.ije = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.ijg <= this.ijf);
        bTX();
        if (!bTW()) {
            return -1;
        }
        byte[] bArr = this.ijd;
        int i = this.ijg;
        this.ijg = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.ijg <= this.ijf);
        bTX();
        if (!bTW()) {
            return -1;
        }
        int min = Math.min(this.ijf - this.ijg, i2);
        System.arraycopy(this.ijd, this.ijg, bArr, i, min);
        this.ijg += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.ijg <= this.ijf);
        bTX();
        return (this.ijf - this.ijg) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.ije.release(this.ijd);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.ijg <= this.ijf);
        bTX();
        int i = this.ijf - this.ijg;
        if (i >= j) {
            this.ijg = (int) (this.ijg + j);
            return j;
        }
        this.ijg = this.ijf;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean bTW() throws IOException {
        if (this.ijg < this.ijf) {
            return true;
        }
        int read = this.mInputStream.read(this.ijd);
        if (read <= 0) {
            return false;
        }
        this.ijf = read;
        this.ijg = 0;
        return true;
    }

    private void bTX() throws IOException {
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
