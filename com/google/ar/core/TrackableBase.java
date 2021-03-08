package com.google.ar.core;
/* loaded from: classes14.dex */
class TrackableBase implements k {
    final Session pSC;
    final long pSD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.pSC = session;
        this.pSD = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).pSD == this.pSD;
    }

    public int hashCode() {
        return Long.valueOf(this.pSD).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.pSD != 0) {
            nativeReleaseTrackable(this.pSD);
        }
        super.finalize();
    }
}
