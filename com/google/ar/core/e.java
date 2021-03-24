package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes6.dex */
public enum e extends ArCoreApk.Availability {
    public e(String str, int i, int i2) {
        super(str, 4, 201, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isSupported() {
        return true;
    }
}
