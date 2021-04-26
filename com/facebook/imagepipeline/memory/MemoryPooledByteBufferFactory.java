package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    public final MemoryChunkPool mPool;
    public final PooledByteStreams mPooledByteStreams;

    public MemoryPooledByteBufferFactory(MemoryChunkPool memoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.mPool = memoryChunkPool;
        this.mPooledByteStreams = pooledByteStreams;
    }

    @VisibleForTesting
    public MemoryPooledByteBuffer newByteBuf(InputStream inputStream, MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream) throws IOException {
        this.mPooledByteStreams.copy(inputStream, memoryPooledByteBufferOutputStream);
        return memoryPooledByteBufferOutputStream.toByteBuffer();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream() {
        return new MemoryPooledByteBufferOutputStream(this.mPool);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream(int i2) {
        return new MemoryPooledByteBufferOutputStream(this.mPool, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(int i2) {
        Preconditions.checkArgument(i2 > 0);
        CloseableReference of = CloseableReference.of(this.mPool.get(i2), this.mPool);
        try {
            return new MemoryPooledByteBuffer(of, i2);
        } finally {
            of.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(byte[] bArr) {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return memoryPooledByteBufferOutputStream.toByteBuffer();
            } catch (IOException e2) {
                throw Throwables.propagate(e2);
            }
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream, int i2) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, i2);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }
}
