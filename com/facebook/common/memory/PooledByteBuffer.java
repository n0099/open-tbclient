package com.facebook.common.memory;

import java.io.Closeable;
/* loaded from: classes3.dex */
public interface PooledByteBuffer extends Closeable {
    byte Qg(int i);

    int c(int i, byte[] bArr, int i2, int i3);

    long euh();

    boolean isClosed();

    int size();

    /* loaded from: classes3.dex */
    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }
}
