package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum TrackingFailureReason {
    NONE(0),
    BAD_STATE(1),
    INSUFFICIENT_LIGHT(2),
    EXCESSIVE_MOTION(3),
    INSUFFICIENT_FEATURES(4);
    
    public final int nativeCode;

    TrackingFailureReason(int i2) {
        this.nativeCode = i2;
    }

    public static TrackingFailureReason forNumber(int i2) {
        TrackingFailureReason[] values;
        for (TrackingFailureReason trackingFailureReason : values()) {
            if (trackingFailureReason.nativeCode == i2) {
                return trackingFailureReason;
            }
        }
        StringBuilder sb = new StringBuilder(68);
        sb.append("Unexpected value for native TrackingFailureReason, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
