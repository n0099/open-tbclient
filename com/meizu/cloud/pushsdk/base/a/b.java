package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f37627a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f37628b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f37629c;

    public b(a aVar, Class<?>... clsArr) {
        this.f37628b = aVar;
        this.f37629c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f37628b.a().getDeclaredConstructor(this.f37629c);
            declaredConstructor.setAccessible(true);
            dVar.f37636b = (T) declaredConstructor.newInstance(objArr);
            dVar.f37635a = true;
        } catch (Exception e2) {
            h.b().a(this.f37627a, "newInstance", e2);
        }
        return dVar;
    }
}
