package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class l implements PooledByteBuffer {
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> kkw;
    private final int mSize;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.kkw = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        cDe();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte BY(int i) {
        byte BY;
        synchronized (this) {
            cDe();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            BY = this.kkw.get().BY(i);
        }
        return BY;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized void c(int i, byte[] bArr, int i2, int i3) {
        cDe();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        this.kkw.get().e(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.kkw);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.kkw);
        this.kkw = null;
    }

    synchronized void cDe() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
