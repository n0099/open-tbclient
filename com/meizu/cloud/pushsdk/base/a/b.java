package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f11522a = "ReflectConstructor";

    /* renamed from: b  reason: collision with root package name */
    private a f11523b;
    private Class<?>[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Class<?>... clsArr) {
        this.f11523b = aVar;
        this.c = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.f11523b.a().getDeclaredConstructor(this.c);
            declaredConstructor.setAccessible(true);
            dVar.f11527b = (T) declaredConstructor.newInstance(objArr);
            dVar.f11526a = true;
        } catch (Exception e) {
            h.b().a(this.f11522a, "newInstance", e);
        }
        return dVar;
    }
}
