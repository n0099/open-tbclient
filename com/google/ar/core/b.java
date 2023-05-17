package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes9.dex */
public enum b extends ArCoreApk.Availability {
    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isTransient() {
        return true;
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }

    public b(String str, int i, int i2) {
        super(str, 1, 1, null);
    }
}
