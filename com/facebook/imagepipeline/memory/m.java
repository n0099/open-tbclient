package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes25.dex */
public class m implements com.facebook.common.memory.g {
    private final com.facebook.common.memory.j nDG;
    private final k nHw;

    public m(k kVar, com.facebook.common.memory.j jVar) {
        this.nHw = kVar;
        this.nDG = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: v */
    public l q(InputStream inputStream) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.nHw);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: aq */
    public l al(byte[] bArr) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.nHw, bArr.length);
        try {
            try {
                nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return nativePooledByteBufferOutputStream.dSO();
            } catch (IOException e) {
                throw com.facebook.common.internal.l.v(e);
            }
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: c */
    public l b(InputStream inputStream, int i) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.nHw, i);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    l a(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) throws IOException {
        this.nDG.e(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.dSO();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: dYX */
    public NativePooledByteBufferOutputStream dSN() {
        return new NativePooledByteBufferOutputStream(this.nHw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: MI */
    public NativePooledByteBufferOutputStream LA(int i) {
        return new NativePooledByteBufferOutputStream(this.nHw, i);
    }
}
