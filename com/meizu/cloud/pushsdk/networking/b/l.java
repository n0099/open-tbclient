package com.meizu.cloud.pushsdk.networking.b;

import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes3.dex */
public abstract class l implements Closeable {
    public abstract com.meizu.cloud.pushsdk.networking.okio.d a();

    public final InputStream b() {
        return a().d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m.a(a());
    }
}
