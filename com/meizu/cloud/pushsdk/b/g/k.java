package com.meizu.cloud.pushsdk.b.g;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface k extends Closeable, Flushable {
    void a(a aVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.l
    void close() throws IOException;

    void flush() throws IOException;
}
