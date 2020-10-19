package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public interface g {
    i Mg(int i);

    PooledByteBuffer al(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i dWy();

    PooledByteBuffer r(InputStream inputStream) throws IOException;
}
