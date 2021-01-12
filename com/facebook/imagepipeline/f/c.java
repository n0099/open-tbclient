package com.facebook.imagepipeline.f;

import java.io.Closeable;
/* loaded from: classes5.dex */
public abstract class c implements f, Closeable {
    public abstract void close();

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public h evO() {
        return g.pAa;
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
