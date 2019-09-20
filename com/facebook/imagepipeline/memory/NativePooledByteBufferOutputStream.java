package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> kmk;
    private final k kml;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cLm());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kml = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.kmk = com.facebook.common.references.a.a(this.kml.get(i), this.kml);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cLo */
    public l cFT() {
        cGg();
        return new l(this.kmk, this.mCount);
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
        cGg();
        En(this.mCount + i2);
        this.kmk.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.kmk);
        this.kmk = null;
        this.mCount = -1;
        super.close();
    }

    void En(int i) {
        cGg();
        if (i > this.kmk.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.kml.get(i);
            this.kmk.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.kmk.close();
            this.kmk = com.facebook.common.references.a.a(nativeMemoryChunk, this.kml);
        }
    }

    private void cGg() {
        if (!com.facebook.common.references.a.a(this.kmk)) {
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
