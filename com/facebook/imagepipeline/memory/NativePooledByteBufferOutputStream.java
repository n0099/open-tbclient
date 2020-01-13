package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes10.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> lTI;
    private final k lTJ;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dpI());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lTJ = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.lTI = com.facebook.common.references.a.a(this.lTJ.get(i), this.lTJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dpK */
    public l djA() {
        djH();
        return new l(this.lTI, this.mCount);
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
        djH();
        Ix(this.mCount + i2);
        this.lTI.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.lTI);
        this.lTI = null;
        this.mCount = -1;
        super.close();
    }

    void Ix(int i) {
        djH();
        if (i > this.lTI.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.lTJ.get(i);
            this.lTI.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.lTI.close();
            this.lTI = com.facebook.common.references.a.a(nativeMemoryChunk, this.lTJ);
        }
    }

    private void djH() {
        if (!com.facebook.common.references.a.a(this.lTI)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes10.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
