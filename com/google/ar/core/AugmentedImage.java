package com.google.ar.core;
/* loaded from: classes9.dex */
public class AugmentedImage extends TrackableBase {
    private native Pose nativeGetCenterPose(long j, long j2);

    private native float nativeGetExtentX(long j, long j2);

    private native float nativeGetExtentZ(long j, long j2);

    private native int nativeGetIndex(long j, long j2);

    private native String nativeGetName(long j, long j2);

    public AugmentedImage(long j, Session session) {
        super(j, session);
    }
}
