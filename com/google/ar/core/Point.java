package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public class Point extends TrackableBase {

    /* loaded from: classes6.dex */
    public enum OrientationMode {
        INITIALIZED_TO_IDENTITY(0),
        ESTIMATED_SURFACE_NORMAL(1);
        
        public final int nativeCode;

        OrientationMode(int i) {
            this.nativeCode = i;
        }

        public static OrientationMode fromNumber(int i) {
            OrientationMode[] values;
            for (OrientationMode orientationMode : values()) {
                if (orientationMode.nativeCode == i) {
                    return orientationMode;
                }
            }
            StringBuilder sb = new StringBuilder(69);
            sb.append("Unexpected value for native Point Orientation Mode, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }
    }

    public Point(long j, Session session) {
        super(j, session);
    }

    private native int nativeGetOrientationMode(long j, long j2);

    private native d.g.b.a.a nativeGetPose(long j, long j2);

    public Point() {
        super(0L, null);
    }
}
