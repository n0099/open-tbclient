package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class l implements PooledByteBuffer {
    private final int mSize;
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> mec;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.mec = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        dnn();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte Ga(int i) {
        byte Ga;
        synchronized (this) {
            dnn();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            Ga = this.mec.get().Ga(i);
        }
        return Ga;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int c(int i, byte[] bArr, int i2, int i3) {
        dnn();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        return this.mec.get().c(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long dne() {
        dnn();
        return this.mec.get().dne();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.mec);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.mec);
        this.mec = null;
    }

    synchronized void dnn() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
