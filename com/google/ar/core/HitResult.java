package com.google.ar.core;
/* loaded from: classes9.dex */
public class HitResult {
    public long a = 0;

    private native long nativeCreateAnchor(long j, long j2);

    public static native void nativeDestroyHitResult(long j);

    private native float nativeGetDistance(long j, long j2);

    private native Pose nativeGetPose(long j, long j2);

    public native long nativeAcquireTrackable(long j, long j2);

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeDestroyHitResult(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.a).hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != HitResult.class || ((HitResult) obj).a != this.a) {
            return false;
        }
        return true;
    }
}
