package com.google.ar.core;
/* loaded from: classes17.dex */
class TrackableBase implements k {
    final Session psW;
    final long psX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.psW = session;
        this.psX = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).psX == this.psX;
    }

    public int hashCode() {
        return Long.valueOf(this.psX).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.psX != 0) {
            nativeReleaseTrackable(this.psX);
        }
        super.finalize();
    }
}
