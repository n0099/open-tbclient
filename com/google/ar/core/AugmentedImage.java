package com.google.ar.core;
/* loaded from: classes5.dex */
public class AugmentedImage extends TrackableBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedImage(long j, Session session) {
        super(j, session);
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native float nativeGetExtentX(long j, long j2);

    private native float nativeGetExtentZ(long j, long j2);

    private native int nativeGetIndex(long j, long j2);

    private native String nativeGetName(long j, long j2);

    @Override // com.google.ar.core.TrackableBase
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.ar.core.TrackableBase
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }
}
