package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes3.dex */
public class b {
    public String a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f60935b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f60936c;

    public b(a aVar, Class<?>... clsArr) {
        this.f60935b = aVar;
        this.f60936c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f60935b.a().getDeclaredConstructor(this.f60936c);
            declaredConstructor.setAccessible(true);
            dVar.f60941b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "newInstance", e2);
        }
        return dVar;
    }
}
