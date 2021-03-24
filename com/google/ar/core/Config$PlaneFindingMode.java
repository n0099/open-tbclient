package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Config$PlaneFindingMode {
    DISABLED(0),
    HORIZONTAL(1),
    VERTICAL(2),
    HORIZONTAL_AND_VERTICAL(3);
    
    public final int nativeCode;

    Config$PlaneFindingMode(int i) {
        this.nativeCode = i;
    }

    public static Config$PlaneFindingMode forNumber(int i) {
        Config$PlaneFindingMode[] values;
        for (Config$PlaneFindingMode config$PlaneFindingMode : values()) {
            if (config$PlaneFindingMode.nativeCode == i) {
                return config$PlaneFindingMode;
            }
        }
        StringBuilder sb = new StringBuilder(63);
        sb.append("Unexpected value for native PlaneFindingMode, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
