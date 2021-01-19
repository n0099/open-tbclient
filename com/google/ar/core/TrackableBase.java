package com.google.ar.core;
/* loaded from: classes5.dex */
class TrackableBase implements k {
    final Session pHi;
    final long pHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.pHi = session;
        this.pHj = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).pHj == this.pHj;
    }

    public int hashCode() {
        return Long.valueOf(this.pHj).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.pHj != 0) {
            nativeReleaseTrackable(this.pHj);
        }
        super.finalize();
    }
}
