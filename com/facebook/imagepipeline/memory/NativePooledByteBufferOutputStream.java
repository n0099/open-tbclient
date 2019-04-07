package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> jII;
    private final k jIJ;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.czc());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.jIJ = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.jII = com.facebook.common.references.a.a(this.jIJ.get(i), this.jIJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cze */
    public l ctL() {
        ctY();
        return new l(this.jII, this.mCount);
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
        ctY();
        Cw(this.mCount + i2);
        this.jII.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.jII);
        this.jII = null;
        this.mCount = -1;
        super.close();
    }

    void Cw(int i) {
        ctY();
        if (i > this.jII.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.jIJ.get(i);
            this.jII.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.jII.close();
            this.jII = com.facebook.common.references.a.a(nativeMemoryChunk, this.jIJ);
        }
    }

    private void ctY() {
        if (!com.facebook.common.references.a.a(this.jII)) {
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
