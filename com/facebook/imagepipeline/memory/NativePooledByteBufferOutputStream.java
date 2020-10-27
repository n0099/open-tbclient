package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> oOe;
    private final k oOf;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.emF());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.oOf = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.oOe = com.facebook.common.references.a.a(this.oOf.get(i), this.oOf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: emH */
    public l egx() {
        egE();
        return new l(this.oOe, this.mCount);
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
        egE();
        Pg(this.mCount + i2);
        this.oOe.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.oOe);
        this.oOe = null;
        this.mCount = -1;
        super.close();
    }

    void Pg(int i) {
        egE();
        if (i > this.oOe.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.oOf.get(i);
            this.oOe.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.oOe.close();
            this.oOe = com.facebook.common.references.a.a(nativeMemoryChunk, this.oOf);
        }
    }

    private void egE() {
        if (!com.facebook.common.references.a.a(this.oOe)) {
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
