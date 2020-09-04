package com.google.ar.core;
/* loaded from: classes11.dex */
class TrackableBase implements k {
    final Session nCl;
    final long nCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.nCl = session;
        this.nCm = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).nCm == this.nCm;
    }

    public int hashCode() {
        return Long.valueOf(this.nCm).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.nCm != 0) {
            nativeReleaseTrackable(this.nCm);
        }
        super.finalize();
    }
}
