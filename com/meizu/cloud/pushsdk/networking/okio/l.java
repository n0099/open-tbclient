package com.meizu.cloud.pushsdk.networking.okio;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes3.dex */
public interface l extends Closeable {
    long b(b bVar, long j) throws IOException;

    @Override // java.lang.AutoCloseable, com.meizu.cloud.pushsdk.networking.okio.l
    void close() throws IOException;
}
