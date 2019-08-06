package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> kjN;
    private final k kjO;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cKy());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kjO = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.kjN = com.facebook.common.references.a.a(this.kjO.get(i), this.kjO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cKA */
    public l cFf() {
        cFs();
        return new l(this.kjN, this.mCount);
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
        cFs();
        Ej(this.mCount + i2);
        this.kjN.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.kjN);
        this.kjN = null;
        this.mCount = -1;
        super.close();
    }

    void Ej(int i) {
        cFs();
        if (i > this.kjN.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.kjO.get(i);
            this.kjN.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.kjN.close();
            this.kjN = com.facebook.common.references.a.a(nativeMemoryChunk, this.kjO);
        }
    }

    private void cFs() {
        if (!com.facebook.common.references.a.a(this.kjN)) {
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
