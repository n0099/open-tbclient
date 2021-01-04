package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public interface g {
    i Qc(int i);

    PooledByteBuffer am(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i eub();

    PooledByteBuffer v(InputStream inputStream) throws IOException;
}
