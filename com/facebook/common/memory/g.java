package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    PooledByteBuffer S(byte[] bArr);

    PooledByteBuffer a(InputStream inputStream, int i) throws IOException;

    i bTh();

    PooledByteBuffer p(InputStream inputStream) throws IOException;

    i xU(int i);
}
