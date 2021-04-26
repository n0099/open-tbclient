package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$UpdateMode {
    BLOCKING(0),
    LATEST_CAMERA_IMAGE(1);
    
    public final int nativeCode;

    Config$UpdateMode(int i2) {
        this.nativeCode = i2;
    }

    public static Config$UpdateMode forNumber(int i2) {
        Config$UpdateMode[] values;
        for (Config$UpdateMode config$UpdateMode : values()) {
            if (config$UpdateMode.nativeCode == i2) {
                return config$UpdateMode;
            }
        }
        StringBuilder sb = new StringBuilder(57);
        sb.append("Unexpected value for native UpdateMode, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
