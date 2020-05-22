package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes13.dex */
public interface g {
    i GN(int i);

    PooledByteBuffer ai(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream, int i) throws IOException;

    i duy();

    PooledByteBuffer q(InputStream inputStream) throws IOException;
}
