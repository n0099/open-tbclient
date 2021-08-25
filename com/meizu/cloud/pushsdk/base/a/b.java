package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f74521a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f74522b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f74523c;

    public b(a aVar, Class<?>... clsArr) {
        this.f74522b = aVar;
        this.f74523c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f74522b.a().getDeclaredConstructor(this.f74523c);
            declaredConstructor.setAccessible(true);
            dVar.f74530b = (T) declaredConstructor.newInstance(objArr);
            dVar.f74529a = true;
        } catch (Exception e2) {
            h.b().a(this.f74521a, "newInstance", e2);
        }
        return dVar;
    }
}
