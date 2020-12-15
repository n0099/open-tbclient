package com.google.ar.core;
/* loaded from: classes17.dex */
class TrackableBase implements k {
    final Session psY;
    final long psZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.psY = session;
        this.psZ = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).psZ == this.psZ;
    }

    public int hashCode() {
        return Long.valueOf(this.psZ).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.psZ != 0) {
            nativeReleaseTrackable(this.psZ);
        }
        super.finalize();
    }
}
