package com.kwad.sdk.lib.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {

    /* renamed from: a  reason: collision with root package name */
    public final List<MODEL> f35946a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final e f35947b = new e();

    @Override // com.kwad.sdk.lib.b.d
    public void a(f fVar) {
        this.f35947b.a(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean a(MODEL model) {
        boolean remove = this.f35946a.remove(model);
        if (remove) {
            this.f35947b.a(false);
        }
        return remove;
    }

    @Override // com.kwad.sdk.lib.b.d
    public void b(f fVar) {
        this.f35947b.b(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean e() {
        return this.f35946a.isEmpty();
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> f() {
        return this.f35946a;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> g() {
        ArrayList arrayList = new ArrayList(this.f35946a.size());
        arrayList.addAll(this.f35946a);
        return arrayList;
    }
}
