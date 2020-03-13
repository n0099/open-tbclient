package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> lUH;
    private final k lUI;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dqZ());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lUI = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.lUH = com.facebook.common.references.a.a(this.lUI.get(i), this.lUI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: drb */
    public l dkS() {
        dkZ();
        return new l(this.lUH, this.mCount);
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
        dkZ();
        IC(this.mCount + i2);
        this.lUH.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.lUH);
        this.lUH = null;
        this.mCount = -1;
        super.close();
    }

    void IC(int i) {
        dkZ();
        if (i > this.lUH.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.lUI.get(i);
            this.lUH.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.lUH.close();
            this.lUH = com.facebook.common.references.a.a(nativeMemoryChunk, this.lUI);
        }
    }

    private void dkZ() {
        if (!com.facebook.common.references.a.a(this.lUH)) {
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
