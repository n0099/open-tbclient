package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes10.dex */
public enum c extends ArCoreApk.Availability {
    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }

    public c(String str, int i, int i2) {
        super(str, 2, 2, null);
    }
}
