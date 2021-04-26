package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes6.dex */
public enum c extends ArCoreApk.Availability {
    public c(String str, int i2, int i3) {
        super(str, 2, 2, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }
}
