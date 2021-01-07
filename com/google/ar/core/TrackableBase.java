package com.google.ar.core;
/* loaded from: classes6.dex */
class TrackableBase implements k {
    final Session pLI;
    final long pLJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.pLI = session;
        this.pLJ = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).pLJ == this.pLJ;
    }

    public int hashCode() {
        return Long.valueOf(this.pLJ).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.pLJ != 0) {
            nativeReleaseTrackable(this.pLJ);
        }
        super.finalize();
    }
}
