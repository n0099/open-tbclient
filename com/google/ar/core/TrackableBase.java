package com.google.ar.core;
/* loaded from: classes15.dex */
class TrackableBase implements k {
    final Session pRn;
    final long pRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.pRn = session;
        this.pRo = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).pRo == this.pRo;
    }

    public int hashCode() {
        return Long.valueOf(this.pRo).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.pRo != 0) {
            nativeReleaseTrackable(this.pRo);
        }
        super.finalize();
    }
}
