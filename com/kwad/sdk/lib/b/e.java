package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36347a;

    /* renamed from: b  reason: collision with root package name */
    public final List<f> f36348b = new CopyOnWriteArrayList();

    public final void a() {
        this.f36348b.clear();
    }

    public void a(f fVar) {
        if (this.f36348b.contains(fVar)) {
            return;
        }
        this.f36348b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f36347a) {
            return;
        }
        for (f fVar : this.f36348b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i, String str) {
        for (f fVar : this.f36348b) {
            fVar.a(z, i, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.f36348b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.f36348b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.f36348b) {
            fVar.b(z, z2);
        }
    }
}
