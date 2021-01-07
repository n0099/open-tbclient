package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public interface g {
    i Qh(int i);

    PooledByteBuffer am(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i eui();

    PooledByteBuffer v(InputStream inputStream) throws IOException;
}
