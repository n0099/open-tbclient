package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f35562a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f35563b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f35564c;

    public b(a aVar, Class<?>... clsArr) {
        this.f35563b = aVar;
        this.f35564c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f35563b.a().getDeclaredConstructor(this.f35564c);
            declaredConstructor.setAccessible(true);
            dVar.f35571b = (T) declaredConstructor.newInstance(objArr);
            dVar.f35570a = true;
        } catch (Exception e2) {
            h.b().a(this.f35562a, "newInstance", e2);
        }
        return dVar;
    }
}
