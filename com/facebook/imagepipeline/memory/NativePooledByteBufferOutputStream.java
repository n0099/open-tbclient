package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> kbw;
    private final k kbx;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cGY());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kbx = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.kbw = com.facebook.common.references.a.a(this.kbx.get(i), this.kbx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cHa */
    public l cBI() {
        cBV();
        return new l(this.kbw, this.mCount);
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
        cBV();
        DA(this.mCount + i2);
        this.kbw.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.kbw);
        this.kbw = null;
        this.mCount = -1;
        super.close();
    }

    void DA(int i) {
        cBV();
        if (i > this.kbw.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.kbx.get(i);
            this.kbw.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.kbw.close();
            this.kbw = com.facebook.common.references.a.a(nativeMemoryChunk, this.kbx);
        }
    }

    private void cBV() {
        if (!com.facebook.common.references.a.a(this.kbw)) {
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
