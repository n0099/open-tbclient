package com.google.ar.core;

import java.io.Closeable;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class PointCloud implements Closeable {
    public long a;

    private native ByteBuffer nativeGetData(long j, long j2);

    private native ByteBuffer nativeGetIds(long j, long j2);

    private native long nativeGetTimestamp(long j, long j2);

    private native void nativeReleasePointCloud(long j);

    public PointCloud() {
        this.a = 0L;
        this.a = 0L;
    }

    public void a() {
        nativeReleasePointCloud(this.a);
        this.a = 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeReleasePointCloud(j);
        }
        super.finalize();
    }
}
