package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$PlaneFindingMode {
    DISABLED(0),
    HORIZONTAL(1),
    VERTICAL(2),
    HORIZONTAL_AND_VERTICAL(3);
    
    public final int nativeCode;

    Config$PlaneFindingMode(int i2) {
        this.nativeCode = i2;
    }

    public static Config$PlaneFindingMode forNumber(int i2) {
        Config$PlaneFindingMode[] values;
        for (Config$PlaneFindingMode config$PlaneFindingMode : values()) {
            if (config$PlaneFindingMode.nativeCode == i2) {
                return config$PlaneFindingMode;
            }
        }
        StringBuilder sb = new StringBuilder(63);
        sb.append("Unexpected value for native PlaneFindingMode, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }
}
