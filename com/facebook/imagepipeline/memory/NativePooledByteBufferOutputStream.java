package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> pNo;
    private final k pNp;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.eyZ());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pNp = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.pNo = com.facebook.common.references.a.a(this.pNp.get(i), this.pNp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: ezb */
    public l esZ() {
        etg();
        return new l(this.pNo, this.mCount);
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
        etg();
        Qh(this.mCount + i2);
        this.pNo.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.pNo);
        this.pNo = null;
        this.mCount = -1;
        super.close();
    }

    void Qh(int i) {
        etg();
        if (i > this.pNo.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.pNp.get(i);
            this.pNo.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.pNo.close();
            this.pNo = com.facebook.common.references.a.a(nativeMemoryChunk, this.pNp);
        }
    }

    private void etg() {
        if (!com.facebook.common.references.a.a(this.pNo)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes5.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
