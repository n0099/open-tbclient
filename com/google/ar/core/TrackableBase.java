package com.google.ar.core;
/* loaded from: classes15.dex */
class TrackableBase implements k {
    final Session pRN;
    final long pRO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.pRN = session;
        this.pRO = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).pRO == this.pRO;
    }

    public int hashCode() {
        return Long.valueOf(this.pRO).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.pRO != 0) {
            nativeReleaseTrackable(this.pRO);
        }
        super.finalize();
    }
}
