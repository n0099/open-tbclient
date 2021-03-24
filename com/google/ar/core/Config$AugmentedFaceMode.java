package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$AugmentedFaceMode {
    DISABLED(0),
    MESH3D(2);
    
    public final int nativeCode;

    Config$AugmentedFaceMode(int i) {
        this.nativeCode = i;
    }

    public static Config$AugmentedFaceMode forNumber(int i) {
        Config$AugmentedFaceMode[] values;
        for (Config$AugmentedFaceMode config$AugmentedFaceMode : values()) {
            if (config$AugmentedFaceMode.nativeCode == i) {
                return config$AugmentedFaceMode;
            }
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Unexpected value for native AugmentedFaceMode, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
