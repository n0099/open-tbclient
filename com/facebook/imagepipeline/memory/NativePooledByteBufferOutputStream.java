package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> mVn;
    private final k mVo;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dFD());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.mVo = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.mVn = com.facebook.common.references.a.a(this.mVo.get(i), this.mVo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dFF */
    public l dzu() {
        dzB();
        return new l(this.mVn, this.mCount);
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
        dzB();
        Jf(this.mCount + i2);
        this.mVn.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.mVn);
        this.mVn = null;
        this.mCount = -1;
        super.close();
    }

    void Jf(int i) {
        dzB();
        if (i > this.mVn.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.mVo.get(i);
            this.mVn.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.mVn.close();
            this.mVn = com.facebook.common.references.a.a(nativeMemoryChunk, this.mVo);
        }
    }

    private void dzB() {
        if (!com.facebook.common.references.a.a(this.mVn)) {
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
