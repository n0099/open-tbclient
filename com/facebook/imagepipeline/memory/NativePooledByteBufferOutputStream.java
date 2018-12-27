package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> isn;
    private final k iso;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.bZj());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.iso = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.isn = com.facebook.common.references.a.a(this.iso.get(i), this.iso);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: bZl */
    public l bTZ() {
        bUm();
        return new l(this.isn, this.mCount);
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
        bUm();
        yR(this.mCount + i2);
        this.isn.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.isn);
        this.isn = null;
        this.mCount = -1;
        super.close();
    }

    void yR(int i) {
        bUm();
        if (i > this.isn.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.iso.get(i);
            this.isn.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.isn.close();
            this.isn = com.facebook.common.references.a.a(nativeMemoryChunk, this.iso);
        }
    }

    private void bUm() {
        if (!com.facebook.common.references.a.a(this.isn)) {
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
