package com.facebook.common.memory;

import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes13.dex */
public abstract class i extends OutputStream {
    public abstract PooledByteBuffer duz();

    public abstract int size();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            l.y(e);
        }
    }
}
