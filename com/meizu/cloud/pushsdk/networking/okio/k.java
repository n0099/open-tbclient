package com.meizu.cloud.pushsdk.networking.okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* loaded from: classes3.dex */
public interface k extends Closeable, Flushable {
    void a(b bVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.networking.okio.l
    void close() throws IOException;

    void flush() throws IOException;
}
