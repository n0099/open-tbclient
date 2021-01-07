package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes6.dex */
enum e extends ArCoreApk.Availability {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, int i, int i2) {
        super(str, 4, 201, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isSupported() {
        return true;
    }
}
