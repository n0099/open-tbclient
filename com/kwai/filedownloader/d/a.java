package com.kwai.filedownloader.d;

import java.io.Closeable;
/* loaded from: classes9.dex */
public interface a extends Closeable {
    void EI();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j);

    void setLength(long j);

    void write(byte[] bArr, int i, int i2);
}
