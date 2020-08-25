package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public class l implements PooledByteBuffer {
    private final int mSize;
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> nxg;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.nxg = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        dOO();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte KU(int i) {
        byte KU;
        synchronized (this) {
            dOO();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            KU = this.nxg.get().KU(i);
        }
        return KU;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int c(int i, byte[] bArr, int i2, int i3) {
        dOO();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        return this.nxg.get().c(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long dOF() {
        dOO();
        return this.nxg.get().dOF();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.nxg);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c(this.nxg);
        this.nxg = null;
    }

    synchronized void dOO() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
