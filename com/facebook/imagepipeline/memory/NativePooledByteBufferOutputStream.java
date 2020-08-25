package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes8.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> nxg;
    private final k nxh;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dUP());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.nxh = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.nxg = com.facebook.common.references.a.a(this.nxh.get(i), this.nxh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dUR */
    public l dOH() {
        dOO();
        return new l(this.nxg, this.mCount);
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
        dOO();
        Me(this.mCount + i2);
        this.nxg.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.nxg);
        this.nxg = null;
        this.mCount = -1;
        super.close();
    }

    void Me(int i) {
        dOO();
        if (i > this.nxg.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.nxh.get(i);
            this.nxg.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.nxg.close();
            this.nxg = com.facebook.common.references.a.a(nativeMemoryChunk, this.nxh);
        }
    }

    private void dOO() {
        if (!com.facebook.common.references.a.a(this.nxg)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes8.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
