package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
/* loaded from: classes5.dex */
enum f extends ArCoreApk.Availability {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, int i, int i2) {
        super(str, 5, 202, null);
    }

    @Override // com.google.ar.core.ArCoreApk.Availability
    public final boolean isSupported() {
        return true;
    }
}
