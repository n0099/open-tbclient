package com.facebook.common.memory;

import java.io.Closeable;
/* loaded from: classes2.dex */
public interface PooledByteBuffer extends Closeable {
    byte BY(int i);

    void c(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    int size();

    /* loaded from: classes2.dex */
    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }
}
