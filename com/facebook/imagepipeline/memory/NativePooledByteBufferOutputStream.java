package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> jJd;
    private final k jJe;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.cyW());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.jJe = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.jJd = com.facebook.common.references.a.a(this.jJe.get(i), this.jJe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: cyY */
    public l ctF() {
        ctS();
        return new l(this.jJd, this.mCount);
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
        ctS();
        CF(this.mCount + i2);
        this.jJd.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.jJd);
        this.jJd = null;
        this.mCount = -1;
        super.close();
    }

    void CF(int i) {
        ctS();
        if (i > this.jJd.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.jJe.get(i);
            this.jJd.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.jJd.close();
            this.jJd = com.facebook.common.references.a.a(nativeMemoryChunk, this.jJe);
        }
    }

    private void ctS() {
        if (!com.facebook.common.references.a.a(this.jJd)) {
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
