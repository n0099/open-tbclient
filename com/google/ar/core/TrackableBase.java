package com.google.ar.core;
/* loaded from: classes5.dex */
class TrackableBase implements k {
    final Session nhZ;
    final long nia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.nhZ = session;
        this.nia = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).nia == this.nia;
    }

    public int hashCode() {
        return Long.valueOf(this.nia).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.nia != 0) {
            nativeReleaseTrackable(this.nia);
        }
        super.finalize();
    }
}
