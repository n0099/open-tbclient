package com.thunder.livesdk.helper;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface IByteBufferPool {
    void clear();

    void freeBuffer(ByteBuffer byteBuffer);

    ByteBuffer newBuffer(int i);

    int totalSize();
}
