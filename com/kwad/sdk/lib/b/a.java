package com.kwad.sdk.lib.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {

    /* renamed from: a  reason: collision with root package name */
    protected final List<MODEL> f10720a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected final e f10721b = new e();

    @Override // com.kwad.sdk.lib.b.d
    public void a(f fVar) {
        this.f10721b.a(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean a(MODEL model) {
        boolean remove = this.f10720a.remove(model);
        if (remove) {
            this.f10721b.a(false);
        }
        return remove;
    }

    @Override // com.kwad.sdk.lib.b.d
    public void b(f fVar) {
        this.f10721b.b(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean e() {
        return this.f10720a.isEmpty();
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> f() {
        return this.f10720a;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> g() {
        ArrayList arrayList = new ArrayList(this.f10720a.size());
        arrayList.addAll(this.f10720a);
        return arrayList;
    }
}
