package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public interface g {
    i Pa(int i);

    PooledByteBuffer am(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i esY();

    PooledByteBuffer s(InputStream inputStream) throws IOException;
}
