package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10431a;

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f10432b = new CopyOnWriteArrayList();

    public final void a() {
        this.f10432b.clear();
    }

    public void a(f fVar) {
        if (this.f10432b.contains(fVar)) {
            return;
        }
        this.f10432b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f10431a) {
            return;
        }
        for (f fVar : this.f10432b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i, String str) {
        for (f fVar : this.f10432b) {
            fVar.a(z, i, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.f10432b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.f10432b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.f10432b) {
            fVar.b(z, z2);
        }
    }
}
