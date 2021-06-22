package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36765a;

    /* renamed from: b  reason: collision with root package name */
    public final List<f> f36766b = new CopyOnWriteArrayList();

    public final void a() {
        this.f36766b.clear();
    }

    public void a(f fVar) {
        if (this.f36766b.contains(fVar)) {
            return;
        }
        this.f36766b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f36765a) {
            return;
        }
        for (f fVar : this.f36766b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i2, String str) {
        for (f fVar : this.f36766b) {
            fVar.a(z, i2, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.f36766b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.f36766b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.f36766b) {
            fVar.b(z, z2);
        }
    }
}
