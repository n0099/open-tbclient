package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> mdY;
    private final k mdZ;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dtu());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.mdZ = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.mdY = com.facebook.common.references.a.a(this.mdZ.get(i), this.mdZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dtw */
    public l dni() {
        dnp();
        return new l(this.mdY, this.mCount);
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
        dnp();
        Hk(this.mCount + i2);
        this.mdY.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.mdY);
        this.mdY = null;
        this.mCount = -1;
        super.close();
    }

    void Hk(int i) {
        dnp();
        if (i > this.mdY.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.mdZ.get(i);
            this.mdY.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.mdY.close();
            this.mdY = com.facebook.common.references.a.a(nativeMemoryChunk, this.mdZ);
        }
    }

    private void dnp() {
        if (!com.facebook.common.references.a.a(this.mdY)) {
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
