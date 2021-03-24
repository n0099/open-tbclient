package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$LightEstimationMode {
    DISABLED(0),
    AMBIENT_INTENSITY(1);
    
    public final int nativeCode;

    Config$LightEstimationMode(int i) {
        this.nativeCode = i;
    }

    public static Config$LightEstimationMode forNumber(int i) {
        Config$LightEstimationMode[] values;
        for (Config$LightEstimationMode config$LightEstimationMode : values()) {
            if (config$LightEstimationMode.nativeCode == i) {
                return config$LightEstimationMode;
            }
        }
        StringBuilder sb = new StringBuilder(66);
        sb.append("Unexpected value for native LightEstimationMode, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
