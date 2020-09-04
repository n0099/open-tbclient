package com.facebook.common.memory;

import java.io.Closeable;
/* loaded from: classes9.dex */
public interface PooledByteBuffer extends Closeable {
    byte KU(int i);

    int c(int i, byte[] bArr, int i2, int i3);

    long dOO();

    boolean isClosed();

    int size();

    /* loaded from: classes9.dex */
    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }
}
