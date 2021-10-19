package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f75055a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f75056b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f75057c;

    public b(a aVar, Class<?>... clsArr) {
        this.f75056b = aVar;
        this.f75057c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f75056b.a().getDeclaredConstructor(this.f75057c);
            declaredConstructor.setAccessible(true);
            dVar.f75064b = (T) declaredConstructor.newInstance(objArr);
            dVar.f75063a = true;
        } catch (Exception e2) {
            h.b().a(this.f75055a, "newInstance", e2);
        }
        return dVar;
    }
}
