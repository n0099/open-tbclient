package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f37290a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f37291b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f37292c;

    public b(a aVar, Class<?>... clsArr) {
        this.f37291b = aVar;
        this.f37292c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f37291b.a().getDeclaredConstructor(this.f37292c);
            declaredConstructor.setAccessible(true);
            dVar.f37299b = (T) declaredConstructor.newInstance(objArr);
            dVar.f37298a = true;
        } catch (Exception e2) {
            h.b().a(this.f37290a, "newInstance", e2);
        }
        return dVar;
    }
}
