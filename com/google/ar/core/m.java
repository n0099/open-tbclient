package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
class m implements ArCoreApk.a {
    final /* synthetic */ AtomicReference ptq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtomicReference atomicReference) {
        this.ptq = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.ptq.set(availability);
    }
}
