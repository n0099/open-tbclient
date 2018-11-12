package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class l implements PooledByteBuffer {
    @GuardedBy("this")
    com.facebook.common.references.a<NativeMemoryChunk> ihR;
    private final int mSize;

    public l(com.facebook.common.references.a<NativeMemoryChunk> aVar, int i) {
        com.facebook.common.internal.g.checkNotNull(aVar);
        com.facebook.common.internal.g.checkArgument(i >= 0 && i <= aVar.get().getSize());
        this.ihR = aVar.clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        bRq();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte xw(int i) {
        byte xw;
        synchronized (this) {
            bRq();
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            xw = this.ihR.get().xw(i);
        }
        return xw;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized void b(int i, byte[] bArr, int i2, int i3) {
        bRq();
        com.facebook.common.internal.g.checkArgument(i + i3 <= this.mSize);
        this.ihR.get().d(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.a(this.ihR);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.ihR);
        this.ihR = null;
    }

    synchronized void bRq() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }
}
