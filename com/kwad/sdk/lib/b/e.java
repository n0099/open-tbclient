package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36252a;

    /* renamed from: b  reason: collision with root package name */
    public final List<f> f36253b = new CopyOnWriteArrayList();

    public final void a() {
        this.f36253b.clear();
    }

    public void a(f fVar) {
        if (this.f36253b.contains(fVar)) {
            return;
        }
        this.f36253b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f36252a) {
            return;
        }
        for (f fVar : this.f36253b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i, String str) {
        for (f fVar : this.f36253b) {
            fVar.a(z, i, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.f36253b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.f36253b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.f36253b) {
            fVar.b(z, z2);
        }
    }
}
