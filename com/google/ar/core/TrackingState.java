package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes24.dex */
public enum TrackingState {
    TRACKING(0),
    PAUSED(1),
    STOPPED(2);
    
    final int nativeCode;

    TrackingState(int i) {
        this.nativeCode = i;
    }

    static TrackingState forNumber(int i) {
        TrackingState[] values;
        for (TrackingState trackingState : values()) {
            if (trackingState.nativeCode == i) {
                return trackingState;
            }
        }
        throw new FatalException(new StringBuilder(60).append("Unexpected value for native TrackingState, value=").append(i).toString());
    }
}
