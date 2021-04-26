package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes6.dex */
public enum a extends ArCoreApk.Availability {
    public a(String str, int i2, int i3) {
        super(str, 0, 0, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }
}
