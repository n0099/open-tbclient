package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public interface g {
    i OV(int i);

    PooledByteBuffer al(byte[] bArr);

    PooledByteBuffer b(InputStream inputStream, int i) throws IOException;

    i ekj();

    PooledByteBuffer r(InputStream inputStream) throws IOException;
}
