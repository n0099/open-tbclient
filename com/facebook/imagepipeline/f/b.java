package com.facebook.imagepipeline.f;

import java.io.Closeable;
/* loaded from: classes2.dex */
public abstract class b implements e, Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public g cHI() {
        return f.kji;
    }

    public boolean isStateful() {
        return false;
    }

    protected void finalize() throws Throwable {
        if (!isClosed()) {
            com.facebook.common.c.a.g("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
