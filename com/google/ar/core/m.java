package com.google.ar.core;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
class m implements ArCoreApk.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtomicReference atomicReference) {
        this.f7861a = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.f7861a.set(availability);
    }
}
