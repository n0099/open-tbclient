package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes2.dex */
public class b {
    public String a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f60354b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f60355c;

    public b(a aVar, Class<?>... clsArr) {
        this.f60354b = aVar;
        this.f60355c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f60354b.a().getDeclaredConstructor(this.f60355c);
            declaredConstructor.setAccessible(true);
            dVar.f60360b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "newInstance", e2);
        }
        return dVar;
    }
}
