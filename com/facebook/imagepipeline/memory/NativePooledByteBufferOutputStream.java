package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> nWM;
    private final k nWN;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.ecH());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.nWN = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.nWM = com.facebook.common.references.a.a(this.nWN.get(i), this.nWN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: ecJ */
    public l dWz() {
        dWG();
        return new l(this.nWM, this.mCount);
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
        dWG();
        Np(this.mCount + i2);
        this.nWM.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.nWM);
        this.nWM = null;
        this.mCount = -1;
        super.close();
    }

    void Np(int i) {
        dWG();
        if (i > this.nWM.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.nWN.get(i);
            this.nWM.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.nWM.close();
            this.nWM = com.facebook.common.references.a.a(nativeMemoryChunk, this.nWN);
        }
    }

    private void dWG() {
        if (!com.facebook.common.references.a.a(this.nWM)) {
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
