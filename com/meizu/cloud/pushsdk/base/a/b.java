package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f38513a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    public a f38514b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?>[] f38515c;

    public b(a aVar, Class<?>... clsArr) {
        this.f38514b = aVar;
        this.f38515c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f38514b.a().getDeclaredConstructor(this.f38515c);
            declaredConstructor.setAccessible(true);
            dVar.f38522b = (T) declaredConstructor.newInstance(objArr);
            dVar.f38521a = true;
        } catch (Exception e2) {
            h.b().a(this.f38513a, "newInstance", e2);
        }
        return dVar;
    }
}
