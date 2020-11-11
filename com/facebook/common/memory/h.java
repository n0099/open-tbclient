package com.facebook.common.memory;

import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class h extends InputStream {
    int mOffset;
    final PooledByteBuffer oLs;
    int oLt;

    public h(PooledByteBuffer pooledByteBuffer) {
        com.facebook.common.internal.g.checkArgument(!pooledByteBuffer.isClosed());
        this.oLs = (PooledByteBuffer) com.facebook.common.internal.g.checkNotNull(pooledByteBuffer);
        this.mOffset = 0;
        this.oLt = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.oLs.size() - this.mOffset;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.oLt = this.mOffset;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.oLs;
        int i = this.mOffset;
        this.mOffset = i + 1;
        return pooledByteBuffer.Or(i) & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        int min = Math.min(available, i2);
        this.oLs.c(this.mOffset, bArr, i, min);
        this.mOffset += min;
        return min;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.mOffset = this.oLt;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        com.facebook.common.internal.g.checkArgument(j >= 0);
        int min = Math.min((int) j, available());
        this.mOffset += min;
        return min;
    }
}
