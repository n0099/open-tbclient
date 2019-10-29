package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    i BZ(int i);

    PooledByteBuffer M(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i cCQ();

    PooledByteBuffer o(InputStream inputStream) throws IOException;
}
