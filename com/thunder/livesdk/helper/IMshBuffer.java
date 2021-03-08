package com.thunder.livesdk.helper;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public interface IMshBuffer {
    void freeBuffer();

    ByteBuffer getByteBuffer();

    int increase_capacity(int i);

    void wrap(byte[] bArr);
}
