package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public interface g {
    i Hp(int i);

    PooledByteBuffer af(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream, int i) throws IOException;

    i djB();

    PooledByteBuffer s(InputStream inputStream) throws IOException;
}
