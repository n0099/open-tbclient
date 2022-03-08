package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes8.dex */
public class b {
    public String a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f57190b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f57191c;

    public b(a aVar, Class<?>... clsArr) {
        this.f57190b = aVar;
        this.f57191c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f57190b.a().getDeclaredConstructor(this.f57191c);
            declaredConstructor.setAccessible(true);
            dVar.f57196b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "newInstance", e2);
        }
        return dVar;
    }
}
