package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f34736a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f34737b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f34738c;

    public b(a aVar, Class<?>... clsArr) {
        this.f34737b = aVar;
        this.f34738c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f34737b.a().getDeclaredConstructor(this.f34738c);
            declaredConstructor.setAccessible(true);
            dVar.f34745b = (T) declaredConstructor.newInstance(objArr);
            dVar.f34744a = true;
        } catch (Exception e2) {
            h.b().a(this.f34736a, "newInstance", e2);
        }
        return dVar;
    }
}
