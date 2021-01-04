package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class m implements com.facebook.common.memory.g {
    private final k pDv;
    private final com.facebook.common.memory.j pzJ;

    public m(k kVar, com.facebook.common.memory.j jVar) {
        this.pDv = kVar;
        this.pzJ = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: A */
    public l v(InputStream inputStream) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.pDv);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: aq */
    public l am(byte[] bArr) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.pDv, bArr.length);
        try {
            try {
                nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return nativePooledByteBufferOutputStream.euc();
            } catch (IOException e) {
                throw com.facebook.common.internal.l.t(e);
            }
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: c */
    public l b(InputStream inputStream, int i) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.pDv, i);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    l a(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) throws IOException {
        this.pzJ.copy(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.euc();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: ezF */
    public NativePooledByteBufferOutputStream eub() {
        return new NativePooledByteBufferOutputStream(this.pDv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: QX */
    public NativePooledByteBufferOutputStream Qc(int i) {
        return new NativePooledByteBufferOutputStream(this.pDv, i);
    }
}
