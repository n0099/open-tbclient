package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public class l implements PooledByteBuffer {
    private final int mSize;
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> pnR;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.pnR = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        eqh();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte PS(int i) {
        byte PS;
        synchronized (this) {
            eqh();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            PS = this.pnR.get().PS(i);
        }
        return PS;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int c(int i, byte[] bArr, int i2, int i3) {
        eqh();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        return this.pnR.get().c(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long epY() {
        eqh();
        return this.pnR.get().epY();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.pnR);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c(this.pnR);
        this.pnR = null;
    }

    synchronized void eqh() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
