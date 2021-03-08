package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f7379a = "ReflectConstructor";
    private a b;
    private Class<?>[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Class<?>... clsArr) {
        this.b = aVar;
        this.c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.b.a().getDeclaredConstructor(this.c);
            declaredConstructor.setAccessible(true);
            dVar.b = (T) declaredConstructor.newInstance(objArr);
            dVar.f7381a = true;
        } catch (Exception e) {
            h.b().a(this.f7379a, "newInstance", e);
        }
        return dVar;
    }
}
