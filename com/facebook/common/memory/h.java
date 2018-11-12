package com.facebook.common.memory;

import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class h extends InputStream {
    final PooledByteBuffer hYK;
    int hYL;
    int mOffset;

    public h(PooledByteBuffer pooledByteBuffer) {
        com.facebook.common.internal.g.checkArgument(!pooledByteBuffer.isClosed());
        this.hYK = (PooledByteBuffer) com.facebook.common.internal.g.checkNotNull(pooledByteBuffer);
        this.mOffset = 0;
        this.hYL = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.hYK.size() - this.mOffset;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.hYL = this.mOffset;
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
        PooledByteBuffer pooledByteBuffer = this.hYK;
        int i = this.mOffset;
        this.mOffset = i + 1;
        return pooledByteBuffer.xw(i) & 255;
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
        this.hYK.b(this.mOffset, bArr, i, min);
        this.mOffset += min;
        return min;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.mOffset = this.hYL;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        com.facebook.common.internal.g.checkArgument(j >= 0);
        int min = Math.min((int) j, available());
        this.mOffset += min;
        return min;
    }
}
