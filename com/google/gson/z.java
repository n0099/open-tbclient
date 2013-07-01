package com.google.gson;
/* loaded from: classes.dex */
class z implements ab {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.b.a f1683a;
    private final boolean b;
    private final Class c;
    private final w d;
    private final q e;

    private z(Object obj, com.google.gson.b.a aVar, boolean z, Class cls) {
        this.d = obj instanceof w ? (w) obj : null;
        this.e = obj instanceof q ? (q) obj : null;
        com.google.gson.internal.a.a((this.d == null && this.e == null) ? false : true);
        this.f1683a = aVar;
        this.b = z;
        this.c = cls;
    }

    @Override // com.google.gson.ab
    public aa a(e eVar, com.google.gson.b.a aVar) {
        boolean isAssignableFrom;
        if (this.f1683a != null) {
            isAssignableFrom = this.f1683a.equals(aVar) || (this.b && this.f1683a.b() == aVar.a());
        } else {
            isAssignableFrom = this.c.isAssignableFrom(aVar.a());
        }
        if (isAssignableFrom) {
            return new x(this.d, this.e, eVar, aVar, this);
        }
        return null;
    }
}
