package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum LightEstimate$State {
    NOT_VALID(0),
    VALID(1);
    
    public final int nativeCode;

    LightEstimate$State(int i2) {
        this.nativeCode = i2;
    }

    public static LightEstimate$State forNumber(int i2) {
        LightEstimate$State[] values;
        for (LightEstimate$State lightEstimate$State : values()) {
            if (lightEstimate$State.nativeCode == i2) {
                return lightEstimate$State;
            }
        }
        StringBuilder sb = new StringBuilder(66);
        sb.append("Unexpected value for native LightEstimate.State, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
