package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public class l implements PooledByteBuffer {
    private final int mSize;
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> oXx;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.oXx = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        ekt();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte Or(int i) {
        byte Or;
        synchronized (this) {
            ekt();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            Or = this.oXx.get().Or(i);
        }
        return Or;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int c(int i, byte[] bArr, int i2, int i3) {
        ekt();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        return this.oXx.get().c(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long ekk() {
        ekt();
        return this.oXx.get().ekk();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.oXx);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c(this.oXx);
        this.oXx = null;
    }

    synchronized void ekt() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
