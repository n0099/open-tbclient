package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f67418a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f67419b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f67420c;

    public b(a aVar, Class<?>... clsArr) {
        this.f67419b = aVar;
        this.f67420c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f67419b.a().getDeclaredConstructor(this.f67420c);
            declaredConstructor.setAccessible(true);
            dVar.f67427b = (T) declaredConstructor.newInstance(objArr);
            dVar.f67426a = true;
        } catch (Exception e2) {
            h.b().a(this.f67418a, "newInstance", e2);
        }
        return dVar;
    }
}
