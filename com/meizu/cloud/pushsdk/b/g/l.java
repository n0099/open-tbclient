package com.meizu.cloud.pushsdk.b.g;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* loaded from: classes3.dex */
public interface l extends Closeable, Flushable {
    void a(b bVar, long j2) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    void close() throws IOException;

    void flush() throws IOException;
}
