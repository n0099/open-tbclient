package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f11222a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    private a f11223b;
    private Class<?>[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Class<?>... clsArr) {
        this.f11223b = aVar;
        this.c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f11223b.a().getDeclaredConstructor(this.c);
            declaredConstructor.setAccessible(true);
            dVar.f11227b = (T) declaredConstructor.newInstance(objArr);
            dVar.f11226a = true;
        } catch (Exception e) {
            h.b().a(this.f11222a, "newInstance", e);
        }
        return dVar;
    }
}
