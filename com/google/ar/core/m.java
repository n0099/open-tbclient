package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
class m implements ArCoreApk.a {
    final /* synthetic */ AtomicReference nis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtomicReference atomicReference) {
        this.nis = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.nis.set(availability);
    }
}
