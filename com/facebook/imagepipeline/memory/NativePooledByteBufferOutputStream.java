package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> pFb;
    private final k pFc;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.eAi());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pFc = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.pFb = com.facebook.common.references.a.a(this.pFc.get(i), this.pFc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: eAk */
    public l euj() {
        euq();
        return new l(this.pFb, this.mCount);
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
        euq();
        Ro(this.mCount + i2);
        this.pFb.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.pFb);
        this.pFb = null;
        this.mCount = -1;
        super.close();
    }

    void Ro(int i) {
        euq();
        if (i > this.pFb.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.pFc.get(i);
            this.pFb.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.pFb.close();
            this.pFb = com.facebook.common.references.a.a(nativeMemoryChunk, this.pFc);
        }
    }

    private void euq() {
        if (!com.facebook.common.references.a.a(this.pFb)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes3.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
