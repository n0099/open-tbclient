package com.kwad.sdk.lib.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {

    /* renamed from: a  reason: collision with root package name */
    protected final List<MODEL> f10422a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected final e f10423b = new e();

    @Override // com.kwad.sdk.lib.b.d
    public void a(f fVar) {
        this.f10423b.a(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean a(MODEL model) {
        boolean remove = this.f10422a.remove(model);
        if (remove) {
            this.f10423b.a(false);
        }
        return remove;
    }

    @Override // com.kwad.sdk.lib.b.d
    public void b(f fVar) {
        this.f10423b.b(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean e() {
        return this.f10422a.isEmpty();
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> f() {
        return this.f10422a;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> g() {
        ArrayList arrayList = new ArrayList(this.f10422a.size());
        arrayList.addAll(this.f10422a);
        return arrayList;
    }
}
