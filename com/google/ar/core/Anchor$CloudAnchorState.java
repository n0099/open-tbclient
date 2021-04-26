package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum Anchor$CloudAnchorState {
    NONE(0),
    TASK_IN_PROGRESS(1),
    SUCCESS(2),
    ERROR_INTERNAL(-1),
    ERROR_NOT_AUTHORIZED(-2),
    ERROR_SERVICE_UNAVAILABLE(-3),
    ERROR_RESOURCE_EXHAUSTED(-4),
    ERROR_HOSTING_DATASET_PROCESSING_FAILED(-5),
    ERROR_CLOUD_ID_NOT_FOUND(-6),
    ERROR_RESOLVING_LOCALIZATION_NO_MATCH(-7),
    ERROR_RESOLVING_SDK_VERSION_TOO_OLD(-8),
    ERROR_RESOLVING_SDK_VERSION_TOO_NEW(-9);
    
    public final int nativeCode;

    Anchor$CloudAnchorState(int i2) {
        this.nativeCode = i2;
    }

    public static Anchor$CloudAnchorState forNumber(int i2) {
        Anchor$CloudAnchorState[] values;
        for (Anchor$CloudAnchorState anchor$CloudAnchorState : values()) {
            if (anchor$CloudAnchorState.nativeCode == i2) {
                return anchor$CloudAnchorState;
            }
        }
        StringBuilder sb = new StringBuilder(63);
        sb.append("Unexpected value for native CloudAnchorState, value=");
        sb.append(i2);
        throw new FatalException(sb.toString());
    }

    public final boolean isError() {
        return this.nativeCode < 0;
    }
}
