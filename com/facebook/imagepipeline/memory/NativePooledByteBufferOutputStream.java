package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> kjF;
    private final k kjG;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cIh());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kjG = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.kjF = com.facebook.common.references.a.a(this.kjG.get(i), this.kjG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cIj */
    public l cCP() {
        cDc();
        return new l(this.kjF, this.mCount);
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
        cDc();
        CI(this.mCount + i2);
        this.kjF.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.kjF);
        this.kjF = null;
        this.mCount = -1;
        super.close();
    }

    void CI(int i) {
        cDc();
        if (i > this.kjF.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.kjG.get(i);
            this.kjF.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.kjF.close();
            this.kjF = com.facebook.common.references.a.a(nativeMemoryChunk, this.kjG);
        }
    }

    private void cDc() {
        if (!com.facebook.common.references.a.a(this.kjF)) {
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
