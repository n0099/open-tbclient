package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> pAB;
    private final k pAC;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.ewq());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pAC = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.pAB = com.facebook.common.references.a.a(this.pAC.get(i), this.pAC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: ews */
    public l eqp() {
        eqw();
        return new l(this.pAB, this.mCount);
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
        eqw();
        PH(this.mCount + i2);
        this.pAB.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.pAB);
        this.pAB = null;
        this.mCount = -1;
        super.close();
    }

    void PH(int i) {
        eqw();
        if (i > this.pAB.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.pAC.get(i);
            this.pAB.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.pAB.close();
            this.pAB = com.facebook.common.references.a.a(nativeMemoryChunk, this.pAC);
        }
    }

    private void eqw() {
        if (!com.facebook.common.references.a.a(this.pAB)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes3.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
