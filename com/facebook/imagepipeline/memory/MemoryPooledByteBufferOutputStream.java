package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    public CloseableReference<MemoryChunk> mBufRef;
    public int mCount;
    public final MemoryChunkPool mPool;

    /* loaded from: classes5.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool) {
        this(memoryChunkPool, memoryChunkPool.getMinBufferSize());
    }

    private void ensureValid() {
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    @VisibleForTesting
    public void realloc(int i) {
        ensureValid();
        if (i <= this.mBufRef.get().getSize()) {
            return;
        }
        MemoryChunk memoryChunk = this.mPool.get(i);
        this.mBufRef.get().copy(0, memoryChunk, 0, this.mCount);
        this.mBufRef.close();
        this.mBufRef = CloseableReference.of(memoryChunk, this.mPool);
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public int size() {
        return this.mCount;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i) {
        Preconditions.checkArgument(i > 0);
        MemoryChunkPool memoryChunkPool2 = (MemoryChunkPool) Preconditions.checkNotNull(memoryChunkPool);
        this.mPool = memoryChunkPool2;
        this.mCount = 0;
        this.mBufRef = CloseableReference.of(memoryChunkPool2.get(i), this.mPool);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        return new MemoryPooledByteBuffer(this.mBufRef, this.mCount);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            ensureValid();
            realloc(this.mCount + i2);
            this.mBufRef.get().write(this.mCount, bArr, i, i2);
            this.mCount += i2;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
    }
}
