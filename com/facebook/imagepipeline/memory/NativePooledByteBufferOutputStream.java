package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> lUw;
    private final k lUx;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dqY());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lUx = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.lUw = com.facebook.common.references.a.a(this.lUx.get(i), this.lUx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dra */
    public l dkR() {
        dkY();
        return new l(this.lUw, this.mCount);
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
        dkY();
        IC(this.mCount + i2);
        this.lUw.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.lUw);
        this.lUw = null;
        this.mCount = -1;
        super.close();
    }

    void IC(int i) {
        dkY();
        if (i > this.lUw.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.lUx.get(i);
            this.lUw.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.lUw.close();
            this.lUw = com.facebook.common.references.a.a(nativeMemoryChunk, this.lUx);
        }
    }

    private void dkY() {
        if (!com.facebook.common.references.a.a(this.lUw)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes12.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
