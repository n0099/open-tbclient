package com.meizu.cloud.pushsdk.b.g;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes3.dex */
public interface m extends Closeable {
    long b(b bVar, long j2) throws IOException;

    @Override // java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    void close() throws IOException;
}
