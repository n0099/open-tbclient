package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class PooledByteArrayBufferedInputStream extends InputStream {
    public static final String TAG = "PooledByteInputStream";
    public final byte[] mByteArray;
    public final InputStream mInputStream;
    public final ResourceReleaser<byte[]> mResourceReleaser;
    public int mBufferedSize = 0;
    public int mBufferOffset = 0;
    public boolean mClosed = false;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        this.mInputStream = (InputStream) Preconditions.checkNotNull(inputStream);
        this.mByteArray = (byte[]) Preconditions.checkNotNull(bArr);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
    }

    private boolean ensureDataInBuffer() throws IOException {
        if (this.mBufferOffset < this.mBufferedSize) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mBufferedSize = read;
        this.mBufferOffset = 0;
        return true;
    }

    private void ensureNotClosed() throws IOException {
        if (this.mClosed) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        return (this.mBufferedSize - this.mBufferOffset) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mClosed) {
            return;
        }
        this.mClosed = true;
        this.mResourceReleaser.release(this.mByteArray);
        super.close();
    }

    public void finalize() throws Throwable {
        if (!this.mClosed) {
            FLog.e(TAG, "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (ensureDataInBuffer()) {
            byte[] bArr = this.mByteArray;
            int i2 = this.mBufferOffset;
            this.mBufferOffset = i2 + 1;
            return bArr[i2] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        int i2 = this.mBufferedSize;
        int i3 = this.mBufferOffset;
        long j2 = i2 - i3;
        if (j2 >= j) {
            this.mBufferOffset = (int) (i3 + j);
            return j;
        }
        this.mBufferOffset = i2;
        return j2 + this.mInputStream.skip(j - j2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (ensureDataInBuffer()) {
            int min = Math.min(this.mBufferedSize - this.mBufferOffset, i3);
            System.arraycopy(this.mByteArray, this.mBufferOffset, bArr, i2, min);
            this.mBufferOffset += min;
            return min;
        }
        return -1;
    }
}
