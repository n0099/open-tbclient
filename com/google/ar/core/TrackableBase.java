package com.google.ar.core;

import com.baidu.tieba.fmb;
/* loaded from: classes9.dex */
public class TrackableBase implements fmb {
    public final long a;
    public final Session b;

    private native long nativeCreateAnchor(long j, long j2, Pose pose);

    private native long[] nativeGetAnchors(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    public static native int nativeGetType(long j, long j2);

    public static native void nativeReleaseTrackable(long j);

    public TrackableBase(long j, Session session) {
        this.b = session;
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass() || ((TrackableBase) obj).a != this.a) {
            return false;
        }
        return true;
    }

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeReleaseTrackable(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.a).hashCode();
    }
}
