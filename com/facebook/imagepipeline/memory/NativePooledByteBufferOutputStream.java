package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes10.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> lTN;
    private final k lTO;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dpK());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lTO = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.lTN = com.facebook.common.references.a.a(this.lTO.get(i), this.lTO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dpM */
    public l djC() {
        djJ();
        return new l(this.lTN, this.mCount);
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
        djJ();
        Ix(this.mCount + i2);
        this.lTN.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.lTN);
        this.lTN = null;
        this.mCount = -1;
        super.close();
    }

    void Ix(int i) {
        djJ();
        if (i > this.lTN.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.lTO.get(i);
            this.lTN.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.lTN.close();
            this.lTN = com.facebook.common.references.a.a(nativeMemoryChunk, this.lTO);
        }
    }

    private void djJ() {
        if (!com.facebook.common.references.a.a(this.lTN)) {
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
