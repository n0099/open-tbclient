package com.google.ar.core;
/* loaded from: classes11.dex */
class TrackableBase implements k {
    final Session oSQ;
    final long oSR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.oSQ = session;
        this.oSR = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).oSR == this.oSR;
    }

    public int hashCode() {
        return Long.valueOf(this.oSR).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.oSR != 0) {
            nativeReleaseTrackable(this.oSR);
        }
        super.finalize();
    }
}
