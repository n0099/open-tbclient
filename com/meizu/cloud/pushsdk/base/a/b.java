package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f37916a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f37917b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f37918c;

    public b(a aVar, Class<?>... clsArr) {
        this.f37917b = aVar;
        this.f37918c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f37917b.a().getDeclaredConstructor(this.f37918c);
            declaredConstructor.setAccessible(true);
            dVar.f37925b = (T) declaredConstructor.newInstance(objArr);
            dVar.f37924a = true;
        } catch (Exception e2) {
            h.b().a(this.f37916a, "newInstance", e2);
        }
        return dVar;
    }
}
