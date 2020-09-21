package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes24.dex */
enum b extends ArCoreApk.Availability {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, int i, int i2) {
        super(str, 1, 1, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isTransient() {
        return true;
    }
}
