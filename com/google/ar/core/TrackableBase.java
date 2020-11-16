package com.google.ar.core;
/* loaded from: classes5.dex */
class TrackableBase implements k {
    final Session pdO;
    final long pdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.pdO = session;
        this.pdP = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).pdP == this.pdP;
    }

    public int hashCode() {
        return Long.valueOf(this.pdP).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.pdP != 0) {
            nativeReleaseTrackable(this.pdP);
        }
        super.finalize();
    }
}
