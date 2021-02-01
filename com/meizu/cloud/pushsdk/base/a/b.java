package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f11224a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    private a f11225b;
    private Class<?>[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Class<?>... clsArr) {
        this.f11225b = aVar;
        this.c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f11225b.a().getDeclaredConstructor(this.c);
            declaredConstructor.setAccessible(true);
            dVar.f11229b = (T) declaredConstructor.newInstance(objArr);
            dVar.f11228a = true;
        } catch (Exception e) {
            h.b().a(this.f11224a, "newInstance", e);
        }
        return dVar;
    }
}
