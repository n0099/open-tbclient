package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f37479a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f37480b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f37481c;

    public b(a aVar, Class<?>... clsArr) {
        this.f37480b = aVar;
        this.f37481c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f37480b.a().getDeclaredConstructor(this.f37481c);
            declaredConstructor.setAccessible(true);
            dVar.f37488b = (T) declaredConstructor.newInstance(objArr);
            dVar.f37487a = true;
        } catch (Exception e2) {
            h.b().a(this.f37479a, "newInstance", e2);
        }
        return dVar;
    }
}
