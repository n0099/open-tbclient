package com.facebook.common.memory;

import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public abstract class i extends OutputStream {
    public abstract PooledByteBuffer cCP();

    public abstract int size();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            k.r(e);
        }
    }
}
