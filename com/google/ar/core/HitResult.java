package com.google.ar.core;
/* loaded from: classes6.dex */
public class HitResult {

    /* renamed from: a  reason: collision with root package name */
    public long f30938a = 0;

    private native long nativeCreateAnchor(long j, long j2);

    public static native void nativeDestroyHitResult(long j);

    private native float nativeGetDistance(long j, long j2);

    private native d.g.b.a.a nativeGetPose(long j, long j2);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == HitResult.class && ((HitResult) obj).f30938a == this.f30938a;
    }

    public void finalize() {
        long j = this.f30938a;
        if (j != 0) {
            nativeDestroyHitResult(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.f30938a).hashCode();
    }

    public native long nativeAcquireTrackable(long j, long j2);
}
