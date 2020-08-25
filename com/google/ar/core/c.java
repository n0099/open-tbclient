package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes11.dex */
enum c extends ArCoreApk.Availability {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, int i, int i2) {
        super(str, 2, 2, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }
}
