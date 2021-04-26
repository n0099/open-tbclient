package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum TrackingState {
    TRACKING(0),
    PAUSED(1),
    STOPPED(2);
    
    public final int nativeCode;

    TrackingState(int i2) {
        this.nativeCode = i2;
    }

    public static TrackingState forNumber(int i2) {
        TrackingState[] values;
        for (TrackingState trackingState : values()) {
            if (trackingState.nativeCode == i2) {
                return trackingState;
            }
        }
        StringBuilder sb = new StringBuilder(60);
        sb.append("Unexpected value for native TrackingState, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
