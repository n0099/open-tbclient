package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35962a;

    /* renamed from: b  reason: collision with root package name */
    public final List<f> f35963b = new CopyOnWriteArrayList();

    public final void a() {
        this.f35963b.clear();
    }

    public void a(f fVar) {
        if (this.f35963b.contains(fVar)) {
            return;
        }
        this.f35963b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f35962a) {
            return;
        }
        for (f fVar : this.f35963b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i, String str) {
        for (f fVar : this.f35963b) {
            fVar.a(z, i, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.f35963b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.f35963b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.f35963b) {
            fVar.b(z, z2);
        }
    }
}
