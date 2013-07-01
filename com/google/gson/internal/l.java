package com.google.gson.internal;
/* loaded from: classes.dex */
class l extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1656a;
    final /* synthetic */ boolean b;
    final /* synthetic */ com.google.gson.e c;
    final /* synthetic */ com.google.gson.b.a d;
    final /* synthetic */ k e;
    private com.google.gson.aa f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, boolean z, boolean z2, com.google.gson.e eVar, com.google.gson.b.a aVar) {
        this.e = kVar;
        this.f1656a = z;
        this.b = z2;
        this.c = eVar;
        this.d = aVar;
    }

    @Override // com.google.gson.aa
    public Object b(com.google.gson.stream.a aVar) {
        if (this.f1656a) {
            aVar.n();
            return null;
        }
        return a().b(aVar);
    }

    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Object obj) {
        if (this.b) {
            dVar.f();
        } else {
            a().a(dVar, obj);
        }
    }

    private com.google.gson.aa a() {
        com.google.gson.aa aaVar = this.f;
        if (aaVar != null) {
            return aaVar;
        }
        com.google.gson.aa a2 = this.c.a(this.e, this.d);
        this.f = a2;
        return a2;
    }
}
