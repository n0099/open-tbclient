package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public interface g {
    i KV(int i);

    PooledByteBuffer al(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i dOP();

    PooledByteBuffer q(InputStream inputStream) throws IOException;
}
