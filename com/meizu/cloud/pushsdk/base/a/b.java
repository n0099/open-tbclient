package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f74321a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f74322b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f74323c;

    public b(a aVar, Class<?>... clsArr) {
        this.f74322b = aVar;
        this.f74323c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f74322b.a().getDeclaredConstructor(this.f74323c);
            declaredConstructor.setAccessible(true);
            dVar.f74330b = (T) declaredConstructor.newInstance(objArr);
            dVar.f74329a = true;
        } catch (Exception e2) {
            h.b().a(this.f74321a, "newInstance", e2);
        }
        return dVar;
    }
}
