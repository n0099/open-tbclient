package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> ipd;
    private final k ipe;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.bYt());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.ipe = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.ipd = com.facebook.common.references.a.a(this.ipe.get(i), this.ipe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: bYv */
    public l bTj() {
        bTw();
        return new l(this.ipd, this.mCount);
    }

    @Override // com.facebook.common.memory.i
    public int size() {
        return this.mCount;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        bTw();
        yE(this.mCount + i2);
        this.ipd.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.ipd);
        this.ipd = null;
        this.mCount = -1;
        super.close();
    }

    void yE(int i) {
        bTw();
        if (i > this.ipd.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.ipe.get(i);
            this.ipd.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.ipd.close();
            this.ipd = com.facebook.common.references.a.a(nativeMemoryChunk, this.ipe);
        }
    }

    private void bTw() {
        if (!com.facebook.common.references.a.a(this.ipd)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes2.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
