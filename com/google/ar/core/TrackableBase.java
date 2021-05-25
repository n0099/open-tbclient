package com.google.ar.core;
/* loaded from: classes6.dex */
public class TrackableBase implements d.g.b.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final long f30776a;

    /* renamed from: b  reason: collision with root package name */
    public final Session f30777b;

    public TrackableBase(long j, Session session) {
        this.f30777b = session;
        this.f30776a = j;
    }

    private native long nativeCreateAnchor(long j, long j2, d.g.b.a.a aVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    public static native int nativeGetType(long j, long j2);

    public static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).f30776a == this.f30776a;
    }

    public void finalize() {
        long j = this.f30776a;
        if (j != 0) {
            nativeReleaseTrackable(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.f30776a).hashCode();
    }
}
