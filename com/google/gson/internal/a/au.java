package com.google.gson.internal.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class au implements com.google.gson.ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f1622a;
    final /* synthetic */ Class b;
    final /* synthetic */ com.google.gson.aa c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(Class cls, Class cls2, com.google.gson.aa aaVar) {
        this.f1622a = cls;
        this.b = cls2;
        this.c = aaVar;
    }

    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        Class a2 = aVar.a();
        if (a2 == this.f1622a || a2 == this.b) {
            return this.c;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.b.getName() + "+" + this.f1622a.getName() + ",adapter=" + this.c + "]";
    }
}
