package com.google.ar.core;
/* loaded from: classes11.dex */
class TrackableBase implements k {
    final long obA;
    final Session obz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.obz = session;
        this.obA = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).obA == this.obA;
    }

    public int hashCode() {
        return Long.valueOf(this.obA).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.obA != 0) {
            nativeReleaseTrackable(this.obA);
        }
        super.finalize();
    }
}
