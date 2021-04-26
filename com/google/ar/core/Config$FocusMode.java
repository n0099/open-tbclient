package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$FocusMode {
    FIXED(0),
    AUTO(1);
    
    public final int nativeCode;

    Config$FocusMode(int i2) {
        this.nativeCode = i2;
    }

    public static Config$FocusMode forNumber(int i2) {
        Config$FocusMode[] values;
        for (Config$FocusMode config$FocusMode : values()) {
            if (config$FocusMode.nativeCode == i2) {
                return config$FocusMode;
            }
        }
        StringBuilder sb = new StringBuilder(56);
        sb.append("Unexpected value for native FocusMode, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
