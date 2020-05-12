package com.facebook.imagepipeline.memory;

import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class NativePooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private int mCount;
    private com.facebook.common.references.a<NativeMemoryChunk> mec;
    private final k med;

    public NativePooledByteBufferOutputStream(k kVar) {
        this(kVar, kVar.dts());
    }

    public NativePooledByteBufferOutputStream(k kVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.med = (k) com.facebook.common.internal.g.checkNotNull(kVar);
        this.mCount = 0;
        this.mec = com.facebook.common.references.a.a(this.med.get(i), this.med);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.i
    /* renamed from: dtu */
    public l dng() {
        dnn();
        return new l(this.mec, this.mCount);
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
        dnn();
        Hk(this.mCount + i2);
        this.mec.get().d(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.mec);
        this.mec = null;
        this.mCount = -1;
        super.close();
    }

    void Hk(int i) {
        dnn();
        if (i > this.mec.get().getSize()) {
            NativeMemoryChunk nativeMemoryChunk = this.med.get(i);
            this.mec.get().a(0, nativeMemoryChunk, 0, this.mCount);
            this.mec.close();
            this.mec = com.facebook.common.references.a.a(nativeMemoryChunk, this.med);
        }
    }

    private void dnn() {
        if (!com.facebook.common.references.a.a(this.mec)) {
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
