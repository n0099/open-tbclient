package com.google.ar.core;
/* loaded from: classes9.dex */
public class Camera {
    public long a = 0;

    public static native long nativeAcquireCamera(long j, long j2);

    private native long nativeCreateCameraIntrinsics(long j);

    private native Pose nativeDisplayOrientedPose(long j, long j2);

    private native void nativeGetImageIntrinsics(long j, long j2, long j3);

    private native Pose nativeGetPose(long j, long j2);

    private native void nativeGetProjectionMatrix(long j, long j2, float[] fArr, int i, float f, float f2);

    private native void nativeGetTextureIntrinsics(long j, long j2, long j3);

    private native int nativeGetTrackingFailureReason(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private native void nativeGetViewMatrix(long j, long j2, float[] fArr, int i);

    public static native void nativeReleaseCamera(long j);

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeReleaseCamera(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.a).hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Camera) || ((Camera) obj).a != this.a) {
            return false;
        }
        return true;
    }
}
