package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> oZa;
    private final k oZb;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.equ());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.oZb = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.oZa = com.facebook.common.references.a.a(this.oZb.get(i), this.oZb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: eqw */
    public l ekk() {
        ekr();
        return new l(this.oZa, this.mCount);
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
        ekr();
        Qe(this.mCount + i2);
        this.oZa.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.oZa);
        this.oZa = null;
        this.mCount = -1;
        super.close();
    }

    void Qe(int i) {
        ekr();
        if (i > this.oZa.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.oZb.get(i);
            this.oZa.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.oZa.close();
            this.oZa = com.facebook.common.references.a.a(nativeMemoryChunk, this.oZb);
        }
    }

    private void ekr() {
        if (!com.facebook.common.references.a.a(this.oZa)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes15.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
