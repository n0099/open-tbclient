package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$AugmentedFaceMode {
    DISABLED(0),
    MESH3D(2);
    
    public final int nativeCode;

    Config$AugmentedFaceMode(int i2) {
        this.nativeCode = i2;
    }

    public static Config$AugmentedFaceMode forNumber(int i2) {
        Config$AugmentedFaceMode[] values;
        for (Config$AugmentedFaceMode config$AugmentedFaceMode : values()) {
            if (config$AugmentedFaceMode.nativeCode == i2) {
                return config$AugmentedFaceMode;
            }
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Unexpected value for native AugmentedFaceMode, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
