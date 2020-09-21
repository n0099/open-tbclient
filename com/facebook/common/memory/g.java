package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes17.dex */
public interface g {
    i LA(int i);

    PooledByteBuffer al(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i dSN();

    PooledByteBuffer q(InputStream inputStream) throws IOException;
}
