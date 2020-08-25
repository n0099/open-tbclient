package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes11.dex */
enum a extends ArCoreApk.Availability {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, int i, int i2) {
        super(str, 0, 0, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnknown() {
        return true;
    }
}
