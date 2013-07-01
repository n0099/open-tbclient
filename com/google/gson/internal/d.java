package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
class d implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Constructor f1648a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Constructor constructor) {
        this.b = bVar;
        this.f1648a = constructor;
    }

    @Override // com.google.gson.internal.n
    public Object a() {
        try {
            return this.f1648a.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke " + this.f1648a + " with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke " + this.f1648a + " with no args", e3.getTargetException());
        }
    }
}
