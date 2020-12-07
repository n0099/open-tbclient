package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes19.dex */
public interface g {
    i PT(int i);

    PooledByteBuffer an(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i epY();

    PooledByteBuffer s(InputStream inputStream) throws IOException;
}
