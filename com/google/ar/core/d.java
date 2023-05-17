package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes9.dex */
public enum d extends ArCoreApk.Availability {
    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnsupported() {
        return true;
    }

    public d(String str, int i, int i2) {
        super(str, 3, 100, null);
    }
}
