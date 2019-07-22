package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    i Dx(int i);

    PooledByteBuffer X(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i cEJ();

    PooledByteBuffer r(InputStream inputStream) throws IOException;
}
