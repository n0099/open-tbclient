package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$CloudAnchorMode {
    DISABLED(0),
    ENABLED(1);
    
    public final int nativeCode;

    Config$CloudAnchorMode(int i) {
        this.nativeCode = i;
    }

    public static Config$CloudAnchorMode forNumber(int i) {
        Config$CloudAnchorMode[] values;
        for (Config$CloudAnchorMode config$CloudAnchorMode : values()) {
            if (config$CloudAnchorMode.nativeCode == i) {
                return config$CloudAnchorMode;
            }
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Unexpected value for native AnchorHostingMode, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
