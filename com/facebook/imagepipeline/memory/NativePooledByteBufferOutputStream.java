package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> pnP;
    private final k pnQ;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.evW());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pnQ = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.pnP = com.facebook.common.references.a.a(this.pnQ.get(i), this.pnQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: evY */
    public l epZ() {
        eqg();
        return new l(this.pnP, this.mCount);
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
        eqg();
        Ra(this.mCount + i2);
        this.pnP.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.pnP);
        this.pnP = null;
        this.mCount = -1;
        super.close();
    }

    void Ra(int i) {
        eqg();
        if (i > this.pnP.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.pnQ.get(i);
            this.pnP.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.pnP.close();
            this.pnP = com.facebook.common.references.a.a(nativeMemoryChunk, this.pnQ);
        }
    }

    private void eqg() {
        if (!com.facebook.common.references.a.a(this.pnP)) {
            throw new InvalidStreamException();
        }
    }

    /* loaded from: classes15.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
