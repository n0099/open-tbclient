package com.google.ar.core;
/* loaded from: classes10.dex */
public class CameraIntrinsics {
    public long a;

    private native long nativeCreateIntrinsics(long j, float f, float f2, float f3, float f4, int i, int i2);

    private native void nativeDestroyCameraIntrinsics(long j);

    private native void nativeGetFocalLength(long j, long j2, float[] fArr, int i);

    private native void nativeGetImageDimensions(long j, long j2, int[] iArr, int i);

    private native void nativeGetPrincipalPoint(long j, long j2, float[] fArr, int i);

    public CameraIntrinsics() {
        this.a = 0L;
        this.a = 0L;
    }

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeDestroyCameraIntrinsics(j);
        }
        super.finalize();
    }
}
