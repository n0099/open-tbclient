package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
class m implements ArCoreApk.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f8160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtomicReference atomicReference) {
        this.f8160a = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.f8160a.set(availability);
    }
}
