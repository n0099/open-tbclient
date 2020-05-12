package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes13.dex */
public interface g {
    i Gb(int i);

    PooledByteBuffer ab(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream, int i) throws IOException;

    i dnf();

    PooledByteBuffer p(InputStream inputStream) throws IOException;
}
