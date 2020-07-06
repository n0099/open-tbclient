package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes13.dex */
public interface g {
    i HW(int i);

    PooledByteBuffer ak(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream, int i) throws IOException;

    i dzt();

    PooledByteBuffer q(InputStream inputStream) throws IOException;
}
