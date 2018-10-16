package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    PooledByteBuffer T(byte[] bArr);

    PooledByteBuffer a(InputStream inputStream, int i) throws IOException;

    i bRH();

    PooledByteBuffer o(InputStream inputStream) throws IOException;

    i xe(int i);
}
