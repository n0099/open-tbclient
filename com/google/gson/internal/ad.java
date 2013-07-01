package com.google.gson.internal;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
final class ad extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Method f1645a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Method method, int i) {
        this.f1645a = method;
        this.b = i;
    }

    @Override // com.google.gson.internal.aa
    public Object a(Class cls) {
        return this.f1645a.invoke(null, cls, Integer.valueOf(this.b));
    }
}
