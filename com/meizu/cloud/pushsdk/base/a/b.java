package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f34807a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f34808b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f34809c;

    public b(a aVar, Class<?>... clsArr) {
        this.f34808b = aVar;
        this.f34809c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f34808b.a().getDeclaredConstructor(this.f34809c);
            declaredConstructor.setAccessible(true);
            dVar.f34816b = (T) declaredConstructor.newInstance(objArr);
            dVar.f34815a = true;
        } catch (Exception e2) {
            h.b().a(this.f34807a, "newInstance", e2);
        }
        return dVar;
    }
}
