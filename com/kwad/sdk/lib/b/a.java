package com.kwad.sdk.lib.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {

    /* renamed from: a  reason: collision with root package name */
    protected final List<MODEL> f6873a = new ArrayList();
    protected final e b = new e();

    @Override // com.kwad.sdk.lib.b.d
    public void a(f fVar) {
        this.b.a(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean a(MODEL model) {
        boolean remove = this.f6873a.remove(model);
        if (remove) {
            this.b.a(false);
        }
        return remove;
    }

    @Override // com.kwad.sdk.lib.b.d
    public void b(f fVar) {
        this.b.b(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean e() {
        return this.f6873a.isEmpty();
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> f() {
        return this.f6873a;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> g() {
        ArrayList arrayList = new ArrayList(this.f6873a.size());
        arrayList.addAll(this.f6873a);
        return arrayList;
    }
}
