package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> mxT;
    private final k mxU;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dAJ());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.mxU = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.mxT = com.facebook.common.references.a.a(this.mxU.get(i), this.mxU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dAL */
    public l duz() {
        duG();
        return new l(this.mxT, this.mCount);
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
        duG();
        HW(this.mCount + i2);
        this.mxT.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.mxT);
        this.mxT = null;
        this.mCount = -1;
        super.close();
    }

    void HW(int i) {
        duG();
        if (i > this.mxT.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.mxU.get(i);
            this.mxT.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.mxT.close();
            this.mxT = com.facebook.common.references.a.a(nativeMemoryChunk, this.mxU);
        }
    }

    private void duG() {
        if (!com.facebook.common.references.a.a(this.mxT)) {
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
