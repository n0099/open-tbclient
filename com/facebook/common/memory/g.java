package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    i BY(int i);

    PooledByteBuffer L(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i cCO();

    PooledByteBuffer o(InputStream inputStream) throws IOException;
}
