package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> igh;
    private final k igi;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.bWS());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.igi = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.igh = com.facebook.common.references.a.a(this.igi.get(i), this.igi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: bWU */
    public l bRI() {
        bRV();
        return new l(this.igh, this.mCount);
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
        bRV();
        xO(this.mCount + i2);
        this.igh.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.igh);
        this.igh = null;
        this.mCount = -1;
        super.close();
    }

    void xO(int i) {
        bRV();
        if (i > this.igh.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.igi.get(i);
            this.igh.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.igh.close();
            this.igh = com.facebook.common.references.a.a(nativeMemoryChunk, this.igi);
        }
    }

    private void bRV() {
        if (!com.facebook.common.references.a.a(this.igh)) {
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
