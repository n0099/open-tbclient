package com.kwad.sdk.lib.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {

    /* renamed from: a  reason: collision with root package name */
    protected final List<MODEL> f10719a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected final e f10720b = new e();

    @Override // com.kwad.sdk.lib.b.d
    public void a(f fVar) {
        this.f10720b.a(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean a(MODEL model) {
        boolean remove = this.f10719a.remove(model);
        if (remove) {
            this.f10720b.a(false);
        }
        return remove;
    }

    @Override // com.kwad.sdk.lib.b.d
    public void b(f fVar) {
        this.f10720b.b(fVar);
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean e() {
        return this.f10719a.isEmpty();
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> f() {
        return this.f10719a;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> g() {
        ArrayList arrayList = new ArrayList(this.f10719a.size());
        arrayList.addAll(this.f10719a);
        return arrayList;
    }
}
