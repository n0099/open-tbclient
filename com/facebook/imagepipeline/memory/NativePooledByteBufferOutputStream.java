package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes25.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> nHv;
    private final k nHw;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dYW());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.nHw = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.nHv = com.facebook.common.references.a.a(this.nHw.get(i), this.nHw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dYY */
    public l dSO() {
        dSV();
        return new l(this.nHv, this.mCount);
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
        dSV();
        MJ(this.mCount + i2);
        this.nHv.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.nHv);
        this.nHv = null;
        this.mCount = -1;
        super.close();
    }

    void MJ(int i) {
        dSV();
        if (i > this.nHv.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.nHw.get(i);
            this.nHv.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.nHv.close();
            this.nHv = com.facebook.common.references.a.a(nativeMemoryChunk, this.nHw);
        }
    }

    private void dSV() {
        if (!com.facebook.common.references.a.a(this.nHv)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes25.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
