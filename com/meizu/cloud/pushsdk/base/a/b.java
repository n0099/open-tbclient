package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f68331a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f68332b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f68333c;

    public b(a aVar, Class<?>... clsArr) {
        this.f68332b = aVar;
        this.f68333c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f68332b.a().getDeclaredConstructor(this.f68333c);
            declaredConstructor.setAccessible(true);
            dVar.f68340b = (T) declaredConstructor.newInstance(objArr);
            dVar.f68339a = true;
        } catch (Exception e2) {
            h.b().a(this.f68331a, "newInstance", e2);
        }
        return dVar;
    }
}
