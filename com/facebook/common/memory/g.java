package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    i DD(int i);

    PooledByteBuffer X(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i cFS();

    PooledByteBuffer r(InputStream inputStream) throws IOException;
}
