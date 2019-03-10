package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> jJw;
    private final k jJx;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.czg());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.jJx = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.jJw = com.facebook.common.references.a.a(this.jJx.get(i), this.jJx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: czi */
    public l ctP() {
        cuc();
        return new l(this.jJw, this.mCount);
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
        cuc();
        CG(this.mCount + i2);
        this.jJw.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.jJw);
        this.jJw = null;
        this.mCount = -1;
        super.close();
    }

    void CG(int i) {
        cuc();
        if (i > this.jJw.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.jJx.get(i);
            this.jJw.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.jJw.close();
            this.jJw = com.facebook.common.references.a.a(nativeMemoryChunk, this.jJx);
        }
    }

    private void cuc() {
        if (!com.facebook.common.references.a.a(this.jJw)) {
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
