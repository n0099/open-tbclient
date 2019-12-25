package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public interface g {
    i Hk(int i);

    PooledByteBuffer ag(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream, int i) throws IOException;

    i diy();

    PooledByteBuffer s(InputStream inputStream) throws IOException;
}
