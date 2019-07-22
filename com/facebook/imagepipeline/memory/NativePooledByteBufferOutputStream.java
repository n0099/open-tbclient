package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> kiH;
    private final k kiI;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cKd());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kiI = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.kiH = com.facebook.common.references.a.a(this.kiI.get(i), this.kiI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cKf */
    public l cEK() {
        cEX();
        return new l(this.kiH, this.mCount);
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
        cEX();
        Eh(this.mCount + i2);
        this.kiH.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.kiH);
        this.kiH = null;
        this.mCount = -1;
        super.close();
    }

    void Eh(int i) {
        cEX();
        if (i > this.kiH.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.kiI.get(i);
            this.kiH.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.kiH.close();
            this.kiH = com.facebook.common.references.a.a(nativeMemoryChunk, this.kiI);
        }
    }

    private void cEX() {
        if (!com.facebook.common.references.a.a(this.kiH)) {
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
