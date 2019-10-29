package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> kkw;
    private final k kkx;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cIj());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kkx = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.kkw = com.facebook.common.references.a.a(this.kkx.get(i), this.kkx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cIl */
    public l cCR() {
        cDe();
        return new l(this.kkw, this.mCount);
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
        cDe();
        CJ(this.mCount + i2);
        this.kkw.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.kkw);
        this.kkw = null;
        this.mCount = -1;
        super.close();
    }

    void CJ(int i) {
        cDe();
        if (i > this.kkw.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.kkx.get(i);
            this.kkw.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.kkw.close();
            this.kkw = com.facebook.common.references.a.a(nativeMemoryChunk, this.kkx);
        }
    }

    private void cDe() {
        if (!com.facebook.common.references.a.a(this.kkw)) {
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
