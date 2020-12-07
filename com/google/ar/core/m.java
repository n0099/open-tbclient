package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
class m implements ArCoreApk.a {
    final /* synthetic */ AtomicReference pto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtomicReference atomicReference) {
        this.pto = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.pto.set(availability);
    }
}
