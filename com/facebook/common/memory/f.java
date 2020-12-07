package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes19.dex */
public class f extends InputStream {
    private final byte[] mByteArray;
    private final InputStream mInputStream;
    private final com.facebook.common.references.c<byte[]> pcb;
    private int pcc = 0;
    private int pcd = 0;
    private boolean mClosed = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.mInputStream = (InputStream) com.facebook.common.internal.g.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.g.checkNotNull(bArr);
        this.pcb = (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        com.facebook.common.internal.g.checkState(this.pcd <= this.pcc);
        epW();
        if (!epV()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.pcd;
        this.pcd = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.facebook.common.internal.g.checkState(this.pcd <= this.pcc);
        epW();
        if (!epV()) {
            return -1;
        }
        int min = Math.min(this.pcc - this.pcd, i2);
        System.arraycopy(this.mByteArray, this.pcd, bArr, i, min);
        this.pcd += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        com.facebook.common.internal.g.checkState(this.pcd <= this.pcc);
        epW();
        return (this.pcc - this.pcd) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.pcb.release(this.mByteArray);
            super.close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        com.facebook.common.internal.g.checkState(this.pcd <= this.pcc);
        epW();
        int i = this.pcc - this.pcd;
        if (i >= j) {
            this.pcd = (int) (this.pcd + j);
            return j;
        }
        this.pcd = this.pcc;
        return i + this.mInputStream.skip(j - i);
    }

    private boolean epV() throws IOException {
        if (this.pcd < this.pcc) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.pcc = read;
        this.pcd = 0;
        return true;
    }

    private void epW() throws IOException {
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
