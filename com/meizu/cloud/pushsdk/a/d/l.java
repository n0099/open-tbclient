package com.meizu.cloud.pushsdk.a.d;

import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes2.dex */
public abstract class l implements Closeable {
    public abstract com.meizu.cloud.pushsdk.a.h.c a();

    public final InputStream b() {
        return a().d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m.a(a());
    }
}
