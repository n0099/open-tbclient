package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes4.dex */
public class b {
    public String a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f58840b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f58841c;

    public b(a aVar, Class<?>... clsArr) {
        this.f58840b = aVar;
        this.f58841c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f58840b.a().getDeclaredConstructor(this.f58841c);
            declaredConstructor.setAccessible(true);
            dVar.f58846b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "newInstance", e2);
        }
        return dVar;
    }
}
