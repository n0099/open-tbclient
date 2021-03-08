package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes14.dex */
enum d extends ArCoreApk.Availability {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, int i, int i2) {
        super(str, 3, 100, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isUnsupported() {
        return true;
    }
}
