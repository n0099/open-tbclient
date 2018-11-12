package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private com.facebook.common.references.a<NativeMemoryChunk> ihR;
    private final k ihS;
    private int mCount;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.bWn());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.ihS = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.ihR = com.facebook.common.references.a.a(this.ihS.get(i), this.ihS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: bWp */
    public l bRd() {
        bRq();
        return new l(this.ihR, this.mCount);
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
        bRq();
        yh(this.mCount + i2);
        this.ihR.get().c(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.ihR);
        this.ihR = null;
        this.mCount = -1;
        super.close();
    }

    void yh(int i) {
        bRq();
        if (i > this.ihR.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.ihS.get(i);
            this.ihR.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.ihR.close();
            this.ihR = com.facebook.common.references.a.a(nativeMemoryChunk, this.ihS);
        }
    }

    private void bRq() {
        if (!com.facebook.common.references.a.a(this.ihR)) {
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
