package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum LightEstimate$State {
    NOT_VALID(0),
    VALID(1);
    
    public final int nativeCode;

    LightEstimate$State(int i) {
        this.nativeCode = i;
    }

    public static LightEstimate$State forNumber(int i) {
        LightEstimate$State[] values;
        for (LightEstimate$State lightEstimate$State : values()) {
            if (lightEstimate$State.nativeCode == i) {
                return lightEstimate$State;
            }
        }
        StringBuilder sb = new StringBuilder(66);
        sb.append("Unexpected value for native LightEstimate.State, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
