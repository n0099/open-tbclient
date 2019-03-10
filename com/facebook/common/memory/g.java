package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface g {
    i BW(int i);

    PooledByteBuffer Y(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i ctO();

    PooledByteBuffer r(InputStream inputStream) throws IOException;
}
