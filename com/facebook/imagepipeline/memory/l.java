package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class l implements PooledByteBuffer {
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> igh;
    private final int mSize;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.igh = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        bRV();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte xd(int i) {
        byte xd;
        synchronized (this) {
            bRV();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            xd = this.igh.get().xd(i);
        }
        return xd;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized void b(int i, byte[] bArr, int i2, int i3) {
        bRV();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        this.igh.get().d(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.igh);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.igh);
        this.igh = null;
    }

    synchronized void bRV() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
