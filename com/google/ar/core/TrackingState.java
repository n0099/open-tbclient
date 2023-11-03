package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes10.dex */
public enum TrackingState {
    TRACKING(0),
    PAUSED(1),
    STOPPED(2);
    
    public final int nativeCode;

    TrackingState(int i) {
        this.nativeCode = i;
    }

    public static TrackingState forNumber(int i) {
        TrackingState[] values;
        for (TrackingState trackingState : values()) {
            if (trackingState.nativeCode == i) {
                return trackingState;
            }
        }
        StringBuilder sb = new StringBuilder(60);
        sb.append("Unexpected value for native TrackingState, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
