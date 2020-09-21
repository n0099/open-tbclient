package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes24.dex */
public enum TrackingFailureReason {
    NONE(0),
    BAD_STATE(1),
    INSUFFICIENT_LIGHT(2),
    EXCESSIVE_MOTION(3),
    INSUFFICIENT_FEATURES(4);
    
    final int nativeCode;

    TrackingFailureReason(int i) {
        this.nativeCode = i;
    }

    static TrackingFailureReason forNumber(int i) {
        TrackingFailureReason[] values;
        for (TrackingFailureReason trackingFailureReason : values()) {
            if (trackingFailureReason.nativeCode == i) {
                return trackingFailureReason;
            }
        }
        throw new FatalException(new StringBuilder(68).append("Unexpected value for native TrackingFailureReason, value=").append(i).toString());
    }
}
