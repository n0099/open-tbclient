package com.google.ar.core;
/* loaded from: classes6.dex */
public class CameraIntrinsics {

    /* renamed from: a  reason: collision with root package name */
    public long f30935a;

    public CameraIntrinsics() {
        this.f30935a = 0L;
        this.f30935a = 0L;
    }

    private native long nativeCreateIntrinsics(long j, float f2, float f3, float f4, float f5, int i2, int i3);

    private native void nativeDestroyCameraIntrinsics(long j);

    private native void nativeGetFocalLength(long j, long j2, float[] fArr, int i2);

    private native void nativeGetImageDimensions(long j, long j2, int[] iArr, int i2);

    private native void nativeGetPrincipalPoint(long j, long j2, float[] fArr, int i2);

    public void finalize() {
        long j = this.f30935a;
        if (j != 0) {
            nativeDestroyCameraIntrinsics(j);
        }
        super.finalize();
    }
}
