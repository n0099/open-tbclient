package com.google.gson.internal;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
final class ab extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Method f1643a;
    final /* synthetic */ Object b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Method method, Object obj) {
        this.f1643a = method;
        this.b = obj;
    }

    @Override // com.google.gson.internal.aa
    public Object a(Class cls) {
        return this.f1643a.invoke(this.b, cls);
    }
}
