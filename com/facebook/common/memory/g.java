package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public interface g {
    i OW(int i);

    PooledByteBuffer ak(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i esP();

    PooledByteBuffer s(InputStream inputStream) throws IOException;
}
