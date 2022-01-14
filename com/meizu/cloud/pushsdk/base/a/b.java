package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes3.dex */
public class b {
    public String a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f58628b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f58629c;

    public b(a aVar, Class<?>... clsArr) {
        this.f58628b = aVar;
        this.f58629c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f58628b.a().getDeclaredConstructor(this.f58629c);
            declaredConstructor.setAccessible(true);
            dVar.f58634b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "newInstance", e2);
        }
        return dVar;
    }
}
