package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes4.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> ndo;
    private final k ndp;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dIP());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.ndp = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.ndo = com.facebook.common.references.a.a(this.ndp.get(i), this.ndp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dIR */
    public l dCG() {
        dCN();
        return new l(this.ndo, this.mCount);
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
        dCN();
        JA(this.mCount + i2);
        this.ndo.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.ndo);
        this.ndo = null;
        this.mCount = -1;
        super.close();
    }

    void JA(int i) {
        dCN();
        if (i > this.ndo.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.ndp.get(i);
            this.ndo.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.ndo.close();
            this.ndo = com.facebook.common.references.a.a(nativeMemoryChunk, this.ndp);
        }
    }

    private void dCN() {
        if (!com.facebook.common.references.a.a(this.ndo)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes4.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
