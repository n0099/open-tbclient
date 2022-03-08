package com.kwad.v8;

import java.io.Closeable;
/* loaded from: classes8.dex */
public interface Releasable extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void release();
}
