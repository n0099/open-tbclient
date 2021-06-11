package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f38415a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f38416b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f38417c;

    public b(a aVar, Class<?>... clsArr) {
        this.f38416b = aVar;
        this.f38417c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f38416b.a().getDeclaredConstructor(this.f38417c);
            declaredConstructor.setAccessible(true);
            dVar.f38424b = (T) declaredConstructor.newInstance(objArr);
            dVar.f38423a = true;
        } catch (Exception e2) {
            h.b().a(this.f38415a, "newInstance", e2);
        }
        return dVar;
    }
}
