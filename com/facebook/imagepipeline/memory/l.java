package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes10.dex */
public class l implements PooledByteBuffer {
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> lTI;
    private final int mSize;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.lTI = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        djH();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte Ho(int i) {
        byte Ho;
        synchronized (this) {
            djH();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            Ho = this.lTI.get().Ho(i);
        }
        return Ho;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int c(int i, byte[] bArr, int i2, int i3) {
        djH();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        return this.lTI.get().c(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long djy() {
        djH();
        return this.lTI.get().djy();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.lTI);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c(this.lTI);
        this.lTI = null;
    }

    synchronized void djH() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
