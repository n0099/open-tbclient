package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class m implements com.facebook.common.memory.g {
    private final com.facebook.common.memory.j mRp;
    private final k mVl;

    public m(k kVar, com.facebook.common.memory.j jVar) {
        this.mVl = kVar;
        this.mRp = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: v */
    public l q(InputStream inputStream) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mVl);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: ap */
    public l ak(byte[] bArr) {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mVl, bArr.length);
        try {
            try {
                nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return nativePooledByteBufferOutputStream.dzq();
            } catch (IOException e) {
                throw com.facebook.common.internal.l.y(e);
            }
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: d */
    public l c(InputStream inputStream, int i) throws IOException {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mVl, i);
        try {
            return a(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    l a(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) throws IOException {
        this.mRp.e(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.dzq();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: dFA */
    public NativePooledByteBufferOutputStream dzp() {
        return new NativePooledByteBufferOutputStream(this.mVl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.g
    /* renamed from: Je */
    public NativePooledByteBufferOutputStream HW(int i) {
        return new NativePooledByteBufferOutputStream(this.mVl, i);
    }
}
