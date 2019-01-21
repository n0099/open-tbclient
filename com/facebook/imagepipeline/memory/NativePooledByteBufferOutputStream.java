package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> itv;
    private final k itw;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.bZR());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.itw = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.itv = com.facebook.common.references.a.a(this.itw.get(i), this.itw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: bZT */
    public l bUH() {
        bUU();
        return new l(this.itv, this.mCount);
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
        bUU();
        yT(this.mCount + i2);
        this.itv.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.itv);
        this.itv = null;
        this.mCount = -1;
        super.close();
    }

    void yT(int i) {
        bUU();
        if (i > this.itv.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.itw.get(i);
            this.itv.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.itv.close();
            this.itv = com.facebook.common.references.a.a(nativeMemoryChunk, this.itw);
        }
    }

    private void bUU() {
        if (!com.facebook.common.references.a.a(this.itv)) {
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
