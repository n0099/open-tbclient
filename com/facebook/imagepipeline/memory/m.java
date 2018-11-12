package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class m implements com.facebook.common.memory.g {
    private final com.facebook.common.memory.j iek;
    private final k ihS;

    public m(k kVar, com.facebook.common.memory.j jVar) {
        this.ihS = kVar;
        this.iek = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: t */
    public l o(InputStream inputStream) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.ihS);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: X */
    public l S(byte[] bArr) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.ihS, bArr.length);
        try {
            try {
                nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return nativePooledByteBufferOutputStream.bRd();
            } catch (IOException e) {
                throw com.facebook.common.internal.k.r(e);
            }
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: b */
    public l a(InputStream inputStream, int i) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.ihS, i);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    l a(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) throws IOException {
        this.iek.f(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.bRd();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: bWo */
    public NativePooledByteBufferOutputStream bRc() {
        return new NativePooledByteBufferOutputStream(this.ihS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: yg */
    public NativePooledByteBufferOutputStream xx(int i) {
        return new NativePooledByteBufferOutputStream(this.ihS, i);
    }
}
