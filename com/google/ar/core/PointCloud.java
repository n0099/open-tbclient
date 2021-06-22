package com.google.ar.core;

import java.io.Closeable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class PointCloud implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public long f30941e;

    public PointCloud() {
        this.f30941e = 0L;
        this.f30941e = 0L;
    }

    private native ByteBuffer nativeGetData(long j, long j2);

    private native ByteBuffer nativeGetIds(long j, long j2);

    private native long nativeGetTimestamp(long j, long j2);

    private native void nativeReleasePointCloud(long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n();
    }

    public void finalize() {
        long j = this.f30941e;
        if (j != 0) {
            nativeReleasePointCloud(j);
        }
        super.finalize();
    }

    public void n() {
        nativeReleasePointCloud(this.f30941e);
        this.f30941e = 0L;
    }
}
