package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10729a;

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f10730b = new CopyOnWriteArrayList();

    public final void a() {
        this.f10730b.clear();
    }

    public void a(f fVar) {
        if (this.f10730b.contains(fVar)) {
            return;
        }
        this.f10730b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f10729a) {
            return;
        }
        for (f fVar : this.f10730b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i, String str) {
        for (f fVar : this.f10730b) {
            fVar.a(z, i, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.f10730b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.f10730b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.f10730b) {
            fVar.b(z, z2);
        }
    }
}
