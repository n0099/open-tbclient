package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f38011a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f38012b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f38013c;

    public b(a aVar, Class<?>... clsArr) {
        this.f38012b = aVar;
        this.f38013c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f38012b.a().getDeclaredConstructor(this.f38013c);
            declaredConstructor.setAccessible(true);
            dVar.f38020b = (T) declaredConstructor.newInstance(objArr);
            dVar.f38019a = true;
        } catch (Exception e2) {
            h.b().a(this.f38011a, "newInstance", e2);
        }
        return dVar;
    }
}
