package com.google.ar.core;
/* loaded from: classes5.dex */
class TrackableBase implements k {
    final Session nib;
    final long nic;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackableBase(long j, Session session) {
        this.nib = session;
        this.nic = j;
    }

    private native long nativeCreateAnchor(long j, long j2, h hVar);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native int nativeGetType(long j, long j2);

    private static native void nativeReleaseTrackable(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((TrackableBase) obj).nic == this.nic;
    }

    public int hashCode() {
        return Long.valueOf(this.nic).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.nic != 0) {
            nativeReleaseTrackable(this.nic);
        }
        super.finalize();
    }
}
