package com.kwai.filedownloader.d;

import java.io.Closeable;
/* loaded from: classes5.dex */
public interface a extends Closeable {
    void a();

    void a(long j);

    void a(byte[] bArr, int i, int i2);

    void b(long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
