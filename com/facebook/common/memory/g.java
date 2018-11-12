package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    PooledByteBuffer S(byte[] bArr);

    PooledByteBuffer a(InputStream inputStream, int i) throws IOException;

    i bRc();

    PooledByteBuffer o(InputStream inputStream) throws IOException;

    i xx(int i);
}
