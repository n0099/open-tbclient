package com.facebook.common.memory;

import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes12.dex */
public abstract class i extends OutputStream {
    public abstract PooledByteBuffer ekk();

    public abstract int size();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            l.v(e);
        }
    }
}
