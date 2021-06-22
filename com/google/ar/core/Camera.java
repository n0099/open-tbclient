package com.google.ar.core;
/* loaded from: classes6.dex */
public class Camera {

    /* renamed from: a  reason: collision with root package name */
    public long f30933a = 0;

    public static native long nativeAcquireCamera(long j, long j2);

    private native long nativeCreateCameraIntrinsics(long j);

    private native d.g.b.a.a nativeDisplayOrientedPose(long j, long j2);

    private native void nativeGetImageIntrinsics(long j, long j2, long j3);

    private native d.g.b.a.a nativeGetPose(long j, long j2);

    private native void nativeGetProjectionMatrix(long j, long j2, float[] fArr, int i2, float f2, float f3);

    private native void nativeGetTextureIntrinsics(long j, long j2, long j3);

    private native int nativeGetTrackingFailureReason(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private native void nativeGetViewMatrix(long j, long j2, float[] fArr, int i2);

    public static native void nativeReleaseCamera(long j);

    public boolean equals(Object obj) {
        return (obj instanceof Camera) && ((Camera) obj).f30933a == this.f30933a;
    }

    public void finalize() {
        long j = this.f30933a;
        if (j != 0) {
            nativeReleaseCamera(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.f30933a).hashCode();
    }
}
