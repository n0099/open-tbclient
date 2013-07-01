package com.google.gson;
/* loaded from: classes.dex */
final class x extends aa {

    /* renamed from: a  reason: collision with root package name */
    private final w f1682a;
    private final q b;
    private final e c;
    private final com.google.gson.b.a d;
    private final ab e;
    private aa f;

    private x(w wVar, q qVar, e eVar, com.google.gson.b.a aVar, ab abVar) {
        this.f1682a = wVar;
        this.b = qVar;
        this.c = eVar;
        this.d = aVar;
        this.e = abVar;
    }

    @Override // com.google.gson.aa
    public Object b(com.google.gson.stream.a aVar) {
        if (this.b == null) {
            return a().b(aVar);
        }
        r a2 = com.google.gson.internal.p.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.b.b(a2, this.d.b(), this.c.f1613a);
    }

    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Object obj) {
        if (this.f1682a == null) {
            a().a(dVar, obj);
        } else if (obj == null) {
            dVar.f();
        } else {
            com.google.gson.internal.p.a(this.f1682a.a(obj, this.d.b(), this.c.b), dVar);
        }
    }

    private aa a() {
        aa aaVar = this.f;
        if (aaVar != null) {
            return aaVar;
        }
        aa a2 = this.c.a(this.e, this.d);
        this.f = a2;
        return a2;
    }

    public static ab a(com.google.gson.b.a aVar, Object obj) {
        return new z(obj, aVar, false, null);
    }
}
