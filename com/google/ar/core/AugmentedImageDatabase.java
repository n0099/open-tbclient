package com.google.ar.core;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AugmentedImageDatabase {

    /* renamed from: a  reason: collision with root package name */
    public long f30932a;

    private native int nativeAddImage(long j, long j2, String str, ByteBuffer byteBuffer, int i2, int i3, int i4);

    private native int nativeAddImageWithPhysicalSize(long j, long j2, String str, ByteBuffer byteBuffer, int i2, int i3, int i4, float f2);

    public static native long nativeCreate(long j);

    public static native long nativeDeserialize(long j, ByteBuffer byteBuffer);

    private native int nativeGetNumImages(long j, long j2);

    private native void nativeReleaseDatabase(long j);

    private native ByteBuffer nativeSerialize(long j, long j2);

    public void finalize() {
        long j = this.f30932a;
        if (j != 0) {
            nativeReleaseDatabase(j);
        }
        super.finalize();
    }
}
