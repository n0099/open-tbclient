package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes10.dex */
public enum a extends ArCoreApk.Availability {
    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }

    public a(String str, int i, int i2) {
        super(str, 0, 0, null);
    }
}
