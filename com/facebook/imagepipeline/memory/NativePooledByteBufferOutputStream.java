package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> pLj;
    private final k pLk;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.eyQ());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pLk = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.pLj = com.facebook.common.references.a.a(this.pLk.get(i), this.pLk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: eyS */
    public l esQ() {
        esX();
        return new l(this.pLj, this.mCount);
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
        esX();
        Qd(this.mCount + i2);
        this.pLj.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.pLj);
        this.pLj = null;
        this.mCount = -1;
        super.close();
    }

    void Qd(int i) {
        esX();
        if (i > this.pLj.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.pLk.get(i);
            this.pLj.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.pLj.close();
            this.pLj = com.facebook.common.references.a.a(nativeMemoryChunk, this.pLk);
        }
    }

    private void esX() {
        if (!com.facebook.common.references.a.a(this.pLj)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes5.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
