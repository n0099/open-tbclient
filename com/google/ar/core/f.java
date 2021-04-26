package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes6.dex */
public enum f extends ArCoreApk.Availability {
    public f(String str, int i2, int i3) {
        super(str, 5, 202, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isSupported() {
        return true;
    }
}
