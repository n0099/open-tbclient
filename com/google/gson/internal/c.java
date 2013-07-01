package com.google.gson.internal;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
class c implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.gson.n f1647a;
    final /* synthetic */ Type b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.google.gson.n nVar, Type type) {
        this.c = bVar;
        this.f1647a = nVar;
        this.b = type;
    }

    @Override // com.google.gson.internal.n
    public Object a() {
        return this.f1647a.a(this.b);
    }
}
