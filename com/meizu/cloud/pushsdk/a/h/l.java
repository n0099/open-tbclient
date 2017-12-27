package com.meizu.cloud.pushsdk.a.h;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface l extends Closeable {
    long b(a aVar, long j) throws IOException;

    @Override // java.lang.AutoCloseable, com.meizu.cloud.pushsdk.a.h.l
    void close() throws IOException;
}
