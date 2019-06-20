package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class l implements PooledByteBuffer {
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> kbA;
    private final int mSize;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.kbA = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        cBW();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte CP(int i) {
        byte CP;
        synchronized (this) {
            cBW();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            CP = this.kbA.get().CP(i);
        }
        return CP;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized void c(int i, byte[] bArr, int i2, int i3) {
        cBW();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        this.kbA.get().e(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.kbA);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c(this.kbA);
        this.kbA = null;
    }

    synchronized void cBW() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
