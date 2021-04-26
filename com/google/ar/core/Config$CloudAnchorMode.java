package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$CloudAnchorMode {
    DISABLED(0),
    ENABLED(1);
    
    public final int nativeCode;

    Config$CloudAnchorMode(int i2) {
        this.nativeCode = i2;
    }

    public static Config$CloudAnchorMode forNumber(int i2) {
        Config$CloudAnchorMode[] values;
        for (Config$CloudAnchorMode config$CloudAnchorMode : values()) {
            if (config$CloudAnchorMode.nativeCode == i2) {
                return config$CloudAnchorMode;
            }
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Unexpected value for native AnchorHostingMode, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
