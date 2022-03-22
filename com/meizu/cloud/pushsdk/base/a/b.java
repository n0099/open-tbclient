package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes7.dex */
public class b {
    public String a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f42029b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f42030c;

    public b(a aVar, Class<?>... clsArr) {
        this.f42029b = aVar;
        this.f42030c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f42029b.a().getDeclaredConstructor(this.f42030c);
            declaredConstructor.setAccessible(true);
            dVar.f42035b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "newInstance", e2);
        }
        return dVar;
    }
}
