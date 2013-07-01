package com.google.gson.internal.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at implements com.google.gson.ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f1621a;
    final /* synthetic */ com.google.gson.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(Class cls, com.google.gson.aa aaVar) {
        this.f1621a = cls;
        this.b = aaVar;
    }

    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        if (aVar.a() == this.f1621a) {
            return this.b;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f1621a.getName() + ",adapter=" + this.b + "]";
    }
}
