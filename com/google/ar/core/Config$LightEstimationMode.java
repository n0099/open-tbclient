package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$LightEstimationMode {
    DISABLED(0),
    AMBIENT_INTENSITY(1);
    
    public final int nativeCode;

    Config$LightEstimationMode(int i2) {
        this.nativeCode = i2;
    }

    public static Config$LightEstimationMode forNumber(int i2) {
        Config$LightEstimationMode[] values;
        for (Config$LightEstimationMode config$LightEstimationMode : values()) {
            if (config$LightEstimationMode.nativeCode == i2) {
                return config$LightEstimationMode;
            }
        }
        StringBuilder sb = new StringBuilder(66);
        sb.append("Unexpected value for native LightEstimationMode, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
