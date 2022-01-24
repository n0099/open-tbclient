package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes3.dex */
public class b {
    public String a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f58673b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f58674c;

    public b(a aVar, Class<?>... clsArr) {
        this.f58673b = aVar;
        this.f58674c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f58673b.a().getDeclaredConstructor(this.f58674c);
            declaredConstructor.setAccessible(true);
            dVar.f58679b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "newInstance", e2);
        }
        return dVar;
    }
}
