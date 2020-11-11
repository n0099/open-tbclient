package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> oXx;
    private final k oXy;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.eqw());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.oXy = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.oXx = com.facebook.common.references.a.a(this.oXy.get(i), this.oXy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: eqy */
    public l ekm() {
        ekt();
        return new l(this.oXx, this.mCount);
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
        ekt();
        PB(this.mCount + i2);
        this.oXx.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.oXx);
        this.oXx = null;
        this.mCount = -1;
        super.close();
    }

    void PB(int i) {
        ekt();
        if (i > this.oXx.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.oXy.get(i);
            this.oXx.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.oXx.close();
            this.oXx = com.facebook.common.references.a.a(nativeMemoryChunk, this.oXy);
        }
    }

    private void ekt() {
        if (!com.facebook.common.references.a.a(this.oXx)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes18.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
