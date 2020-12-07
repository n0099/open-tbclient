package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes17.dex */
public class Plane extends TrackableBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Plane(long j, Session session) {
        super(j, session);
    }

    private native long nativeAcquireSubsumedBy(long j, long j2);

    private native h nativeGetCenterPose(long j, long j2);

    private native float nativeGetExtentX(long j, long j2);

    private native float nativeGetExtentZ(long j, long j2);

    private native float[] nativeGetPolygon(long j, long j2);

    private native int nativeGetType(long j, long j2);

    private native boolean nativeIsPoseInExtents(long j, long j2, h hVar);

    private native boolean nativeIsPoseInPolygon(long j, long j2, h hVar);

    /* loaded from: classes17.dex */
    public enum Type {
        HORIZONTAL_UPWARD_FACING(0),
        HORIZONTAL_DOWNWARD_FACING(1),
        VERTICAL(2);
        
        final int nativeCode;

        Type(int i) {
            this.nativeCode = i;
        }

        static Type forNumber(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.nativeCode == i) {
                    return type;
                }
            }
            throw new FatalException(new StringBuilder(57).append("Unexpected value for native Plane.Type, value=").append(i).toString());
        }
    }

    protected Plane() {
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
