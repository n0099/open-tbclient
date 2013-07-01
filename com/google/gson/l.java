package com.google.gson;
/* loaded from: classes.dex */
class l extends aa {

    /* renamed from: a  reason: collision with root package name */
    private aa f1669a;

    public void a(aa aaVar) {
        if (this.f1669a != null) {
            throw new AssertionError();
        }
        this.f1669a = aaVar;
    }

    @Override // com.google.gson.aa
    public Object b(com.google.gson.stream.a aVar) {
        if (this.f1669a == null) {
            throw new IllegalStateException();
        }
        return this.f1669a.b(aVar);
    }

    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Object obj) {
        if (this.f1669a == null) {
            throw new IllegalStateException();
        }
        this.f1669a.a(dVar, obj);
    }
}
