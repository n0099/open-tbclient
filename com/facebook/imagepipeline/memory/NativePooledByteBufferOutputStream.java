package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> mVk;
    private final k mVl;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dFz());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.mVl = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.mVk = com.facebook.common.references.a.a(this.mVl.get(i), this.mVl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dFB */
    public l dzq() {
        dzx();
        return new l(this.mVk, this.mCount);
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
        dzx();
        Jf(this.mCount + i2);
        this.mVk.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.mVk);
        this.mVk = null;
        this.mCount = -1;
        super.close();
    }

    void Jf(int i) {
        dzx();
        if (i > this.mVk.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.mVl.get(i);
            this.mVk.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.mVk.close();
            this.mVk = com.facebook.common.references.a.a(nativeMemoryChunk, this.mVl);
        }
    }

    private void dzx() {
        if (!com.facebook.common.references.a.a(this.mVk)) {
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
