package com.facebook.common.memory;

import java.io.Closeable;
/* loaded from: classes14.dex */
public interface PooledByteBuffer extends Closeable {
    byte Oz(int i);

    int c(int i, byte[] bArr, int i2, int i3);

    long eqn();

    boolean isClosed();

    int size();

    /* loaded from: classes14.dex */
    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }
}
