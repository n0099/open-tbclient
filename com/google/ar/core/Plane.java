package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes8.dex */
public class Plane extends TrackableBase {
    private native long nativeAcquireSubsumedBy(long j, long j2);

    private native Pose nativeGetCenterPose(long j, long j2);

    private native float nativeGetExtentX(long j, long j2);

    private native float nativeGetExtentZ(long j, long j2);

    private native float[] nativeGetPolygon(long j, long j2);

    private native int nativeGetType(long j, long j2);

    private native boolean nativeIsPoseInExtents(long j, long j2, Pose pose);

    private native boolean nativeIsPoseInPolygon(long j, long j2, Pose pose);

    public Plane() {
        super(0L, null);
    }

    public Type getType() {
        return Type.forNumber(nativeGetType(this.b.a, this.a));
    }

    /* loaded from: classes8.dex */
    public enum Type {
        HORIZONTAL_UPWARD_FACING(0),
        HORIZONTAL_DOWNWARD_FACING(1),
        VERTICAL(2);
        
        public final int nativeCode;

        Type(int i) {
            this.nativeCode = i;
        }

        public static Type forNumber(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.nativeCode == i) {
                    return type;
                }
            }
            StringBuilder sb = new StringBuilder(57);
            sb.append("Unexpected value for native Plane.Type, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }
    }

    public Plane(long j, Session session) {
        super(j, session);
    }
}
