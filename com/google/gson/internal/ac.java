package com.google.gson.internal;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
final class ac extends aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Method f1644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Method method) {
        this.f1644a = method;
    }

    @Override // com.google.gson.internal.aa
    public Object a(Class cls) {
        return this.f1644a.invoke(null, cls, Object.class);
    }
}
