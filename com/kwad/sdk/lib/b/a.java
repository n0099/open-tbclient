package com.kwad.sdk.lib.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {

    /* renamed from: a  reason: collision with root package name */
    public final List<MODEL> f36749a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final e f36750b = new e();

    @Override // com.kwad.sdk.lib.b.d
    public void a(f fVar) {
        this.f36750b.a(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean a(MODEL model) {
        boolean remove = this.f36749a.remove(model);
        if (remove) {
            this.f36750b.a(false);
        }
        return remove;
    }

    @Override // com.kwad.sdk.lib.b.d
    public void b(f fVar) {
        this.f36750b.b(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean e() {
        return this.f36749a.isEmpty();
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> f() {
        return this.f36749a;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> g() {
        ArrayList arrayList = new ArrayList(this.f36749a.size());
        arrayList.addAll(this.f36749a);
        return arrayList;
    }
}
