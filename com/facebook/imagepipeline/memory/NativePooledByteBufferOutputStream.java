package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> pKJ;
    private final k pKK;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.eyI());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pKK = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.pKJ = com.facebook.common.references.a.a(this.pKK.get(i), this.pKK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: eyK */
    public l esI() {
        esP();
        return new l(this.pKJ, this.mCount);
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
        esP();
        Qc(this.mCount + i2);
        this.pKJ.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.pKJ);
        this.pKJ = null;
        this.mCount = -1;
        super.close();
    }

    void Qc(int i) {
        esP();
        if (i > this.pKJ.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.pKK.get(i);
            this.pKJ.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.pKJ.close();
            this.pKJ = com.facebook.common.references.a.a(nativeMemoryChunk, this.pKK);
        }
    }

    private void esP() {
        if (!com.facebook.common.references.a.a(this.pKJ)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes5.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
