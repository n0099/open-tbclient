package com.google.gson.internal.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax implements com.google.gson.ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f1624a;
    final /* synthetic */ com.google.gson.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(Class cls, com.google.gson.aa aaVar) {
        this.f1624a = cls;
        this.b = aaVar;
    }

    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        if (this.f1624a.isAssignableFrom(aVar.a())) {
            return this.b;
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.f1624a.getName() + ",adapter=" + this.b + "]";
    }
}
