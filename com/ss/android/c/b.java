package com.ss.android.c;

import java.io.IOException;
/* loaded from: classes4.dex */
public interface b {
    void V(long j, long j2) throws IOException;

    void close() throws IOException;

    long length() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;
}
