package com.kwad.sdk.lib.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6878a;
    private final List<f> b = new CopyOnWriteArrayList();

    public final void a() {
        this.b.clear();
    }

    public void a(f fVar) {
        if (this.b.contains(fVar)) {
            return;
        }
        this.b.add(fVar);
    }

    public void a(boolean z) {
        if (this.f6878a) {
            return;
        }
        for (f fVar : this.b) {
            fVar.a(z);
        }
    }

    public void a(boolean z, int i, String str) {
        for (f fVar : this.b) {
            fVar.a(z, i, str);
        }
    }

    public void a(boolean z, boolean z2) {
        for (f fVar : this.b) {
            fVar.a(z, z2);
        }
    }

    public void b(f fVar) {
        this.b.remove(fVar);
    }

    public void b(boolean z, boolean z2) {
        for (f fVar : this.b) {
            fVar.b(z, z2);
        }
    }
}
