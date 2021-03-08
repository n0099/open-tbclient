package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes14.dex */
public class Point extends TrackableBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Point(long j, Session session) {
        super(j, session);
    }

    private native int nativeGetOrientationMode(long j, long j2);

    private native h nativeGetPose(long j, long j2);

    /* loaded from: classes14.dex */
    public enum OrientationMode {
        INITIALIZED_TO_IDENTITY(0),
        ESTIMATED_SURFACE_NORMAL(1);
        
        private final int nativeCode;

        OrientationMode(int i) {
            this.nativeCode = i;
        }

        static OrientationMode fromNumber(int i) {
            OrientationMode[] values;
            for (OrientationMode orientationMode : values()) {
                if (orientationMode.nativeCode == i) {
                    return orientationMode;
                }
            }
            throw new FatalException(new StringBuilder(69).append("Unexpected value for native Point Orientation Mode, value=").append(i).toString());
        }
    }

    protected Point() {
        super(0L, null);
    }

    @Override // com.google.ar.core.TrackableBase
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.ar.core.TrackableBase
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }
}
