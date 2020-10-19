package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes11.dex */
class m implements ArCoreApk.a {
    final /* synthetic */ AtomicReference obR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtomicReference atomicReference) {
        this.obR = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.obR.set(availability);
    }
}
