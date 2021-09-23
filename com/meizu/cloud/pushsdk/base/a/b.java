package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f75020a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f75021b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f75022c;

    public b(a aVar, Class<?>... clsArr) {
        this.f75021b = aVar;
        this.f75022c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f75021b.a().getDeclaredConstructor(this.f75022c);
            declaredConstructor.setAccessible(true);
            dVar.f75029b = (T) declaredConstructor.newInstance(objArr);
            dVar.f75028a = true;
        } catch (Exception e2) {
            h.b().a(this.f75020a, "newInstance", e2);
        }
        return dVar;
    }
}
