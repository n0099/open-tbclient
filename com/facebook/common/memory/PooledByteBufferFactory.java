package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public interface PooledByteBufferFactory {
    PooledByteBuffer newByteBuffer(int i2);

    PooledByteBuffer newByteBuffer(InputStream inputStream) throws IOException;

    PooledByteBuffer newByteBuffer(InputStream inputStream, int i2) throws IOException;

    PooledByteBuffer newByteBuffer(byte[] bArr);

    PooledByteBufferOutputStream newOutputStream();

    PooledByteBufferOutputStream newOutputStream(int i2);
}
