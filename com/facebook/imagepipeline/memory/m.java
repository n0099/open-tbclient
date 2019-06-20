package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class m implements com.facebook.common.memory.g {
    private final com.facebook.common.memory.j jXR;
    private final k kbB;

    public m(k kVar, com.facebook.common.memory.j jVar) {
        this.kbB = kVar;
        this.jXR = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: w */
    public l r(InputStream inputStream) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.kbB);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: ab */
    public l W(byte[] bArr) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.kbB, bArr.length);
        try {
            try {
                nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return nativePooledByteBufferOutputStream.cBJ();
            } catch (IOException e) {
                throw com.facebook.common.internal.k.r(e);
            }
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: c */
    public l b(InputStream inputStream, int i) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.kbB, i);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    l a(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) throws IOException {
        this.jXR.g(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.cBJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: cHa */
    public NativePooledByteBufferOutputStream cBI() {
        return new NativePooledByteBufferOutputStream(this.kbB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: Dz */
    public NativePooledByteBufferOutputStream CQ(int i) {
        return new NativePooledByteBufferOutputStream(this.kbB, i);
    }
}
