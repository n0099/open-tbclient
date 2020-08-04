package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public interface g {
    i Ir(int i);

    PooledByteBuffer ak(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream, int i) throws IOException;

    i dCG();

    PooledByteBuffer p(InputStream inputStream) throws IOException;
}
