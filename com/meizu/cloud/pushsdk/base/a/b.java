package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67419a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f67420b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f67421c;

    public b(a aVar, Class<?>... clsArr) {
        this.f67420b = aVar;
        this.f67421c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f67420b.a().getDeclaredConstructor(this.f67421c);
            declaredConstructor.setAccessible(true);
            dVar.f67428b = (T) declaredConstructor.newInstance(objArr);
            dVar.f67427a = true;
        } catch (Exception e2) {
            h.b().a(this.f67419a, "newInstance", e2);
        }
        return dVar;
    }
}
