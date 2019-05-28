package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> kbx;
    private final k kby;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cHa());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kby = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.kbx = com.facebook.common.references.a.a(this.kby.get(i), this.kby);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cHc */
    public l cBK() {
        cBX();
        return new l(this.kbx, this.mCount);
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
        cBX();
        DA(this.mCount + i2);
        this.kbx.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.kbx);
        this.kbx = null;
        this.mCount = -1;
        super.close();
    }

    void DA(int i) {
        cBX();
        if (i > this.kbx.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.kby.get(i);
            this.kbx.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.kbx.close();
            this.kbx = com.facebook.common.references.a.a(nativeMemoryChunk, this.kby);
        }
    }

    private void cBX() {
        if (!com.facebook.common.references.a.a(this.kbx)) {
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
