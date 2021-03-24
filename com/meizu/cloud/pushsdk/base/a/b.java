package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f37626a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f37627b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f37628c;

    public b(a aVar, Class<?>... clsArr) {
        this.f37627b = aVar;
        this.f37628c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f37627b.a().getDeclaredConstructor(this.f37628c);
            declaredConstructor.setAccessible(true);
            dVar.f37635b = (T) declaredConstructor.newInstance(objArr);
            dVar.f37634a = true;
        } catch (Exception e2) {
            h.b().a(this.f37626a, "newInstance", e2);
        }
        return dVar;
    }
}
