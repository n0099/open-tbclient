package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes14.dex */
public interface g {
    i OA(int i);

    PooledByteBuffer al(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i eqo();

    PooledByteBuffer v(InputStream inputStream) throws IOException;
}
