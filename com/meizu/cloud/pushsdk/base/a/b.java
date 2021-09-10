package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f74701a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f74702b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f74703c;

    public b(a aVar, Class<?>... clsArr) {
        this.f74702b = aVar;
        this.f74703c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f74702b.a().getDeclaredConstructor(this.f74703c);
            declaredConstructor.setAccessible(true);
            dVar.f74710b = (T) declaredConstructor.newInstance(objArr);
            dVar.f74709a = true;
        } catch (Exception e2) {
            h.b().a(this.f74701a, "newInstance", e2);
        }
        return dVar;
    }
}
