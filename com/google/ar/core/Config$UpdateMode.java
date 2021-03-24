package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$UpdateMode {
    BLOCKING(0),
    LATEST_CAMERA_IMAGE(1);
    
    public final int nativeCode;

    Config$UpdateMode(int i) {
        this.nativeCode = i;
    }

    public static Config$UpdateMode forNumber(int i) {
        Config$UpdateMode[] values;
        for (Config$UpdateMode config$UpdateMode : values()) {
            if (config$UpdateMode.nativeCode == i) {
                return config$UpdateMode;
            }
        }
        StringBuilder sb = new StringBuilder(57);
        sb.append("Unexpected value for native UpdateMode, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
