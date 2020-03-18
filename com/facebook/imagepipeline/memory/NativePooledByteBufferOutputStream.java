package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> lWn;
    private final k lWo;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.drw());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lWo = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.lWn = com.facebook.common.references.a.a(this.lWo.get(i), this.lWo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dry */
    public l dlp() {
        dlw();
        return new l(this.lWn, this.mCount);
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
        dlw();
        II(this.mCount + i2);
        this.lWn.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.lWn);
        this.lWn = null;
        this.mCount = -1;
        super.close();
    }

    void II(int i) {
        dlw();
        if (i > this.lWn.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.lWo.get(i);
            this.lWn.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.lWn.close();
            this.lWn = com.facebook.common.references.a.a(nativeMemoryChunk, this.lWo);
        }
    }

    private void dlw() {
        if (!com.facebook.common.references.a.a(this.lWn)) {
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
