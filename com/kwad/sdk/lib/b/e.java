package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36667a;

    /* renamed from: b  reason: collision with root package name */
    public final List<f> f36668b = new CopyOnWriteArrayList();

    public final void a() {
        this.f36668b.clear();
    }

    public void a(f fVar) {
        if (this.f36668b.contains(fVar)) {
            return;
        }
        this.f36668b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f36667a) {
            return;
        }
        for (f fVar : this.f36668b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i2, String str) {
        for (f fVar : this.f36668b) {
            fVar.a(z, i2, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.f36668b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.f36668b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.f36668b) {
            fVar.b(z, z2);
        }
    }
}
