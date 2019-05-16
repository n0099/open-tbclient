package com.meizu.cloud.pushsdk.b.g;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes3.dex */
public interface l extends Closeable {
    long b(a aVar, long j) throws IOException;

    @Override // java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.l
    void close() throws IOException;
}
