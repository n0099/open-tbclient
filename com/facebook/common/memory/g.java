package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    i CQ(int i);

    PooledByteBuffer W(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i cBJ();

    PooledByteBuffer r(InputStream inputStream) throws IOException;
}
