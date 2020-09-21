package com.google.ar.core;
/* loaded from: classes24.dex */
class TrackableBase implements k {
    final Session nMh;
    final long nMi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.nMh = session;
        this.nMi = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).nMi == this.nMi;
    }

    public int hashCode() {
        return Long.valueOf(this.nMi).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.nMi != 0) {
            nativeReleaseTrackable(this.nMi);
        }
        super.finalize();
    }
}
