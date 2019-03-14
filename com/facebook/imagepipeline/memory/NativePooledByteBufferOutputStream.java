package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> jJo;
    private final k jJp;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.czj());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.jJp = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.jJo = com.facebook.common.references.a.a(this.jJp.get(i), this.jJp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: czl */
    public l ctS() {
        cuf();
        return new l(this.jJo, this.mCount);
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
        cuf();
        CG(this.mCount + i2);
        this.jJo.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.jJo);
        this.jJo = null;
        this.mCount = -1;
        super.close();
    }

    void CG(int i) {
        cuf();
        if (i > this.jJo.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.jJp.get(i);
            this.jJo.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.jJo.close();
            this.jJo = com.facebook.common.references.a.a(nativeMemoryChunk, this.jJp);
        }
    }

    private void cuf() {
        if (!com.facebook.common.references.a.a(this.jJo)) {
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
